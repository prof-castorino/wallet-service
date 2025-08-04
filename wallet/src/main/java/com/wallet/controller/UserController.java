package com.wallet.controller;

import com.wallet.model.User;
import com.wallet.model.Wallet;
import com.wallet.service.UserService;
import com.wallet.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUser request) {
        return ResponseEntity.ok(service.createUser(request));
    }

    @GetMapping("/{document}")
    public User getUser(@PathVariable("document") String document) {
        return ResponseEntity.ok(service.getUser(document)).getBody();
    }

    @GetMapping("/{document}/wallets")
    public List<Wallet> getWallets(@PathVariable("document") String document) {
        return ResponseEntity.ok(service.getWallets(document)).getBody();
    }
}
