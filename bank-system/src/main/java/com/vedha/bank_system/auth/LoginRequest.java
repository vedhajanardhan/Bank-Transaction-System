package com.vedha.bank_system.auth;

import lombok.Data;

@Data
public class LoginRequest {

    private String email;
    private String password;
}
