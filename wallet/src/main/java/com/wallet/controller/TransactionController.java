package com.wallet.controller;

import com.wallet.dto.*;
import com.wallet.model.Transaction;
import com.wallet.service.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping("/{walletId}/deposit")
    public ResponseEntity<Transaction> deposit(@PathVariable("walletId") Long walletId,
                                               @RequestBody TransactionRequest request) {
        Transaction tx = service.deposit(walletId, request.amount);
        return ResponseEntity.ok(tx);
    }

    @PostMapping("/{walletId}/withdraw")
    public ResponseEntity<Transaction> withdraw(@PathVariable("walletId") Long walletId,
                                         @RequestBody TransactionRequest request) {
        Transaction tx = service.withdraw(walletId, request.amount);
        return ResponseEntity.ok(tx);
    }

    @PostMapping("/{walletId}/transfer")
    public ResponseEntity<Transaction> transfer(@PathVariable("walletId") Long walletId,
                                         @RequestBody TransferRequest request) {
        Transaction tx = service.transfer(walletId, request.toWalletId, request.amount);
        return ResponseEntity.ok(tx);
    }
}
