package com.wallet.service;

import com.wallet.dto.CreateUser;
import com.wallet.model.User;
import com.wallet.model.Wallet;

import java.util.List;

public interface UserService {
    User createUser(CreateUser request);
    User getUser(String document);
    List<Wallet> getWallets(String document);
}