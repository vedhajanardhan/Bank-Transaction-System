package com.vedha.bank_system.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TransferRequest {

    @Schema(description = "Sender account number")
    private String fromAccount;

    @Schema(description = "Receiver account number")
    private String toAccount;

    @Schema(description = "Transfer amount")
    private Double amount;
}