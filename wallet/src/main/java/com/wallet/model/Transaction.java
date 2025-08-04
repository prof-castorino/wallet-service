package com.wallet.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_wallet_id")
    private Wallet fromWallet;

    @ManyToOne
    @JoinColumn(name = "to_wallet_id" , nullable = true)
    private Wallet toWallet;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionState state;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private Instant timestamp = Instant.now();

    // Getters and Setters
}