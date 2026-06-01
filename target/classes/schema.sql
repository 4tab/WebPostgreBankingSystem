CREATE TABLE IF NOT EXISTS account (
    id BIGSERIAL PRIMARY KEY,
    owner_name VARCHAR(255),
    balance DECIMAL(19,2)
);