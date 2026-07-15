package com.vedha.bank_system.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import com.vedha.bank_system.entity.Customer;
import com.vedha.bank_system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vedha.bank_system.dto.CustomerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public CustomerResponse registerCustomer(Customer customer) {

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        Customer savedCustomer = customerRepository.save(customer);

        CustomerResponse response = new CustomerResponse();

        response.setCustomerId(savedCustomer.getCustomerId());
        response.setFullName(savedCustomer.getFullName());
        response.setEmail(savedCustomer.getEmail());
        response.setPhone(savedCustomer.getPhone());
        logger.info("Customer registered successfully: {}", savedCustomer.getEmail());

        return response;
    }
}
