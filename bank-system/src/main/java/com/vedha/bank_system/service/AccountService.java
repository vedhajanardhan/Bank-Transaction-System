package com.vedha.bank_system.service;
import com.vedha.bank_system.repository.TransactionRepository;
import com.vedha.bank_system.entity.Transaction;
import java.time.LocalDateTime;
import org.springframework.transaction.annotation.Transactional;
import com.vedha.bank_system.entity.Account;
import com.vedha.bank_system.entity.Customer;
import com.vedha.bank_system.repository.AccountRepository;
import com.vedha.bank_system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vedha.bank_system.exception.ResourceNotFoundException;
import com.vedha.bank_system.dto.AccountResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

@Service
public class AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public AccountResponse createAccount(Long customerId, String accountType) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Account account = new Account();

        account.setAccountNumber(String.valueOf(1000000000L + new Random().nextInt(900000000)));

        account.setAccountType(accountType);

        account.setBalance(0.0);

        account.setStatus("ACTIVE");

        account.setBranchName("Bangalore Main Branch");

        account.setIfscCode("SBIN0001234");

        account.setCustomer(customer);

        Account savedAccount = accountRepository.save(account);

        AccountResponse response = new AccountResponse();

        response.setAccountId(savedAccount.getAccountId());
        response.setAccountNumber(savedAccount.getAccountNumber());
        response.setAccountType(savedAccount.getAccountType());
        response.setBalance(savedAccount.getBalance());
        response.setStatus(savedAccount.getStatus());
        response.setBranchName(savedAccount.getBranchName());
        response.setIfscCode(savedAccount.getIfscCode());
        logger.info("Bank account created successfully: {}", savedAccount.getAccountNumber());

        return response;
    }

    public Account deposit(String accountNumber, Double amount) {

        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));

        account.setBalance(account.getBalance() + amount);
        logger.info("Deposit successful. Account: {}, Amount: {}", account.getAccountNumber(), amount);

        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setTransactionType("DEPOSIT");
        transaction.setAmount(amount);
        transaction.setTransactionTime(LocalDateTime.now());
        transaction.setAccount(account);

        transactionRepository.save(transaction);

        return account;
    }

    public Account withdraw(String accountNumber, Double amount) {

        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient Balance");
        }

        account.setBalance(account.getBalance() - amount);
        logger.info("Withdrawal successful. Account: {}, Amount: {}",
                account.getAccountNumber(), amount);

        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setTransactionType("WITHDRAW");
        transaction.setAmount(amount);
        transaction.setTransactionTime(LocalDateTime.now());
        transaction.setAccount(account);

        transactionRepository.save(transaction);

        return account;
    }

    @Transactional
    public void transfer(String fromAccount,
                         String toAccount,
                         Double amount) {

        Account sender = accountRepository.findByAccountNumber(fromAccount)
                .orElseThrow(() -> new ResourceNotFoundException("Sender account not found"));

        Account receiver = accountRepository.findByAccountNumber(toAccount)
                .orElseThrow(() -> new ResourceNotFoundException("Receiver account not found"));

        if (sender.getBalance() < amount) {
            throw new RuntimeException("Insufficient Balance");
        }

        sender.setBalance(sender.getBalance() - amount);

        receiver.setBalance(receiver.getBalance() + amount);

        accountRepository.save(sender);
        accountRepository.save(receiver);
        Transaction debitTransaction = new Transaction();
        debitTransaction.setTransactionType("TRANSFER_DEBIT");
        debitTransaction.setAmount(amount);
        debitTransaction.setTransactionTime(LocalDateTime.now());
        debitTransaction.setAccount(sender);

        transactionRepository.save(debitTransaction);

        Transaction creditTransaction = new Transaction();
        creditTransaction.setTransactionType("TRANSFER_CREDIT");
        creditTransaction.setAmount(amount);
        creditTransaction.setTransactionTime(LocalDateTime.now());
        creditTransaction.setAccount(receiver);
        logger.info("Transfer successful. From: {}, To: {}, Amount: {}",
                sender.getAccountNumber(),
                receiver.getAccountNumber(),
                amount);

        transactionRepository.save(creditTransaction);
    }
    public Double checkBalance(String accountNumber) {

        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));

        return account.getBalance();
    }
}