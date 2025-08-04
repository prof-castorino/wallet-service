package com.wallet.service.impl;

import com.wallet.exception.AmountIsNotPositionException;
import com.wallet.exception.CannotTransferWalletException;
import com.wallet.exception.InsufficientBalanceException;
import com.wallet.model.*;
import com.wallet.repository.*;
import com.wallet.service.TransactionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final WalletRepository walletRepo;
    private final TransactionRepository transactionRepo;

    public TransactionServiceImpl( WalletRepository walletRepo, TransactionRepository transactionRepo) {
        this.walletRepo = walletRepo;
        this.transactionRepo = transactionRepo;
    }

    @Override
    @Transactional
    public Transaction deposit(Long walletId, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new AmountIsNotPositionException();

        Wallet wallet = walletRepo.findById(walletId).orElseThrow();
        wallet.setBalance(wallet.getBalance().add(amount));
        walletRepo.save(wallet);
        return this.createTransaction( wallet,  amount,  TransactionType.DEPOSIT);
    }

    @Override
    @Transactional
    public Transaction withdraw(Long walletId, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new AmountIsNotPositionException();

        Wallet wallet = walletRepo.findById(walletId).orElseThrow();
        if (wallet.getBalance().compareTo(amount) < 0)
            throw new InsufficientBalanceException();

        wallet.setBalance(wallet.getBalance().subtract(amount));
        walletRepo.save(wallet);
        return this.createTransaction( wallet,  amount,  TransactionType.WITHDRAWAL);
    }

    @Override
    @Transactional
    public Transaction transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        if (fromWalletId.equals(toWalletId))
            throw new CannotTransferWalletException();

        Wallet fromWallet = walletRepo.findById(fromWalletId).orElseThrow();
        if (fromWallet.getBalance().compareTo(amount) < 0)
            throw new InsufficientBalanceException();

        Wallet toWallet = walletRepo.findById(toWalletId).orElseThrow();
        if (toWallet.getId().equals(fromWallet.getId()))
            throw new CannotTransferWalletException();

        fromWallet.setBalance(fromWallet.getBalance().subtract(amount));
        toWallet.setBalance(toWallet.getBalance().add(amount));

        walletRepo.save(fromWallet);
        walletRepo.save(toWallet);

        return this.transfer( fromWallet, toWallet, amount);
    }

    private Transaction transfer(Wallet fromWallet, Wallet toWallet, BigDecimal amount) {
        Transaction tx =  Transaction.builder()
                .fromWallet(fromWallet)
                .toWallet(toWallet)
                .amount(amount)
                .type(TransactionType.TRANSFER)
                .timestamp(Instant.now())
                .state(TransactionState.PENDING) // Assuming pending state initially
                .build();
        transactionRepo.save(tx);
        return tx;
    }

    private Transaction createTransaction(Wallet wallet, BigDecimal amount, TransactionType type) {
        Transaction tx =  Transaction.builder()
                .fromWallet(wallet)
                .amount(amount)
                .type(type)
                .timestamp(Instant.now())
                .state(TransactionState.COMPLETED) // Assuming pending state initially
                .build();
        transactionRepo.save(tx);
        return tx;
    }
}
