package com.vedha.bank_system.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import com.vedha.bank_system.entity.Customer;
import com.vedha.bank_system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vedha.bank_system.dto.CustomerResponse;

@Tag(name = "Customer Controller", description = "Customer Management APIs")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Operation(
            summary = "Register Customer",
            description = "Registers a new customer in the banking system."
    )

    @PostMapping("/register")
    public CustomerResponse registerCustomer(@Valid @RequestBody Customer customer){
        return customerService.registerCustomer(customer);
    }
}
