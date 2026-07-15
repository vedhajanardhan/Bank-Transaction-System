package com.vedha.bank_system.controller;
import com.vedha.bank_system.dto.TransferRequest;
import com.vedha.bank_system.dto.DepositRequest;
import com.vedha.bank_system.entity.Account;
import com.vedha.bank_system.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.vedha.bank_system.dto.AccountResponse;

@Tag(name = "Account Controller", description = "Bank Account APIs")
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Operation(
            summary = "Create Bank Account",
            description = "Creates a new bank account for an existing customer."
    )

    @PostMapping("/create/{customerId}")
    public AccountResponse createAccount(@PathVariable Long customerId,
                                 @RequestParam String accountType) {

        return accountService.createAccount(customerId, accountType);
    }
    @Operation(
            summary = "Deposit Money",
            description = "Deposits money into the specified account."
    )

    @PostMapping("/deposit")
    public Account deposit(@RequestBody DepositRequest request) {

        return accountService.deposit(
                request.getAccountNumber(),
                request.getAmount()
        );
    }
    @Operation(
            summary = "Withdraw Money",
            description = "Withdraws money from the specified account."
    )

    @PostMapping("/withdraw")
    public Account withdraw(@RequestBody DepositRequest request) {

        return accountService.withdraw(
                request.getAccountNumber(),
                request.getAmount()
        );
    }
    @Operation(
            summary = "Transfer Money",
            description = "Transfers money from one account to another."
    )

    @PostMapping("/transfer")
    public String transfer(@RequestBody TransferRequest request) {

        accountService.transfer(
                request.getFromAccount(),
                request.getToAccount(),
                request.getAmount()
        );

        return "Money Transferred Successfully";
    }
    @Operation(
            summary = "Check Balance",
            description = "Returns the current balance of an account."
    )
    @GetMapping("/balance/{accountNumber}")
    public Double checkBalance(@PathVariable String accountNumber) {

        return accountService.checkBalance(accountNumber);
    }
}