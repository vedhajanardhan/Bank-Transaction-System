package com.vedha.bank_system.dto;

import lombok.Data;

@Data
public class CustomerResponse {

    private Long customerId;
    private String fullName;
    private String email;
    private String phone;
}
