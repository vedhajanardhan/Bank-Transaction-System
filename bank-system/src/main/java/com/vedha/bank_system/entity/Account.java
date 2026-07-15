package com.vedha.bank_system.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.vedha.bank_system.entity.Customer;

@Entity
@Table(name = "accounts")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private String accountType;

    @Column(nullable = false)
    private Double balance;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String branchName;

    @Column(nullable = false)
    private String ifscCode;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}