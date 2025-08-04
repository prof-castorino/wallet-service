package com.wallet.service;

import com.wallet.model.Transaction;

import java.math.BigDecimal;

public interface TransactionService {
    Transaction deposit(Long walletId, BigDecimal amount);
    Transaction withdraw(Long walletId, BigDecimal amount);
    Transaction transfer(Long fromWalletId, Long toWalletId, BigDecimal amount);
}