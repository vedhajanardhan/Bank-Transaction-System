package com.vedha.bank_system.dto;

import lombok.Data;

@Data
public class AccountResponse {

    private Long accountId;
    private String accountNumber;
    private String accountType;
    private Double balance;
    private String status;
    private String branchName;
    private String ifscCode;
}
