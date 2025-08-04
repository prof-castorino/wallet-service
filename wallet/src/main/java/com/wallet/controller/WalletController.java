package com.wallet.controller;

import com.wallet.dto.*;
import com.wallet.model.Transaction;
import com.wallet.model.Wallet;
import com.wallet.service.WalletService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    private final WalletService service;

    public WalletController(WalletService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Wallet> createWallet(@RequestBody CreateWalletRequest request) {
        return ResponseEntity.ok(service.createWallet(request.userId));
    }

    @GetMapping("/{walletId}/balance")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable("walletId") Long walletId) {
        return ResponseEntity.ok(service.getBalance(walletId));
    }

    @GetMapping("/{walletId}/balance-at")
    public ResponseEntity<List<Transaction>> getHistoricalBalance(@RequestParam("dateAt") Instant dateAt,
                                                                  @PathVariable("walletId") Long walletId) {
        return ResponseEntity.ok(service.getHistoricalBalance(walletId, dateAt));
    }
}
