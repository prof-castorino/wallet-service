package com.wallet.service.impl;

import com.wallet.dto.CreateUser;
import com.wallet.exception.IsNotFieldException;
import com.wallet.model.*;
import com.wallet.repository.*;
import com.wallet.service.UserService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final WalletRepository walletRepo;

    public UserServiceImpl(UserRepository userRepo, WalletRepository walletRepo) {
        this.userRepo = userRepo;
        this.walletRepo = walletRepo;
    }

    @Override
    public User createUser(CreateUser request) {
        if (request.name == null || request.document == null || request.email == null) {
            throw new IsNotFieldException();
        }

        User user = User.builder()
                .name(request.name)
                .document(request.document)
                .email(request.email)
                .createdAt(Instant.now())
                .build();
        try {
            return userRepo.save(user);

        } catch (Exception e) {
            throw new IsNotFieldException("User with this document already exists");
            // User does not exist, proceed to save
        }

    }
    @Override
    public User getUser(String document) {
        return userRepo.findByDocument(document).orElseThrow();
    }
    @Override
    public List<Wallet> getWallets(String document) {
        User user = userRepo.findByDocument(document).orElseThrow();
        return walletRepo.findByUser(user);
    }

}
