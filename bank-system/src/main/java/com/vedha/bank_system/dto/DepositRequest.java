package com.vedha.bank_system.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class DepositRequest {

    @Schema(description = "Bank account number")
    private String accountNumber;

    @Schema(description = "Amount to deposit")
    private Double amount;

}