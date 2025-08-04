CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    document VARCHAR(100) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE wallets (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    balance NUMERIC(19, 2) NOT NULL DEFAULT 0.00,
    createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user_wallet FOREIGN KEY (user_id)
        REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE transactions (
    id SERIAL PRIMARY KEY,
    from_wallet_id INTEGER NOT NULL,
    to_wallet_id INTEGER NULL,
    amount NUMERIC(19, 2) NOT NULL,
    type VARCHAR(20) NOT NULL,
    state VARCHAR(20) NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    CONSTRAINT fk_wallet_transaction FOREIGN KEY (from_wallet_id)
        REFERENCES wallets (id) ON DELETE CASCADE
);