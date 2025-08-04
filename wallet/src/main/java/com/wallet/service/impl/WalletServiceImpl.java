package com.wallet.service.impl;

import com.wallet.model.*;
import com.wallet.repository.*;
import com.wallet.service.WalletService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {

    private final UserRepository userRepo;
    private final WalletRepository walletRepo;
    private final TransactionRepository transactionRepo;

    public WalletServiceImpl(UserRepository userRepo, WalletRepository walletRepo, TransactionRepository transactionRepo) {
        this.userRepo = userRepo;
        this.walletRepo = walletRepo;
        this.transactionRepo = transactionRepo;
    }

    @Override
    public Wallet createWallet(Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        Wallet wallet = Wallet.builder()
                .balance(BigDecimal.ZERO)
                .user(user)
                .createdAt(Instant.now())
                .build();
        return walletRepo.save(wallet);
    }

    @Override
    public BigDecimal getBalance(Long walletId) {
        return walletRepo.findById(walletId).orElseThrow().getBalance();
    }

    @Override
    public List<Transaction> getHistoricalBalance(Long walletId, Instant timestamp) {
        return transactionRepo.findByFromWalletIdOrToWalletIdAndTimestampBefore(walletId, walletId, timestamp);
    }
}
