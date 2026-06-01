package za.co._4tab.banking.service;

import org.springframework.stereotype.Service;
import za.co._4tab.banking.model.Account;
import za.co._4tab.banking.repo.AccountRepository;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final AccountRepository repo;

    public AccountService(AccountRepository repo) {
        this.repo = repo;
    }

    public Account createAccount(String name) {
        Account acc = new Account();
        acc.setOwnerName(name);
        acc.setBalance(BigDecimal.ZERO);
        return repo.save(acc);
    }
}