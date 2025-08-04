package com.wallet.service;

import com.wallet.model.Transaction;
import com.wallet.model.Wallet;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public interface WalletService {
    Wallet createWallet(Long userId);
    BigDecimal getBalance(Long walletId);
    List<Transaction> getHistoricalBalance(Long walletId, Instant timestamp);
}