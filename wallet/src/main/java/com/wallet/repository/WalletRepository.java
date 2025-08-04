package com.wallet.repository;

import com.wallet.model.User;
import com.wallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByUserId(Long userId);
    List<Wallet> findByUser(User user);
}
