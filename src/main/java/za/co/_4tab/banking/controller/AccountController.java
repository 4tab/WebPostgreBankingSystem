package za.co._4tab.banking.controller;

import org.springframework.web.bind.annotation.*;
import za.co._4tab.banking.model.Account;
import za.co._4tab.banking.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public Account createAccount(@RequestParam String name) {
        return service.createAccount(name);
    }
}