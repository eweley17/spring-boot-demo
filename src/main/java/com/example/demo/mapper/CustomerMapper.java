package com.example.demo.mapper;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;

public class CustomerMapper {

    public static CustomerDTO mapToCustomerDTO(Customer customer, Account account) {
        return new CustomerDTO(
                customer.getId(),
                customer.getCustomerId(),
                customer.getPhoneNumber(),
                customer.getEmail(),
                customer.getAddress(),
                account.getAccountNumber(),
                account.getAccountType(),
                account.getAccountName(),
                account.getAccountBalance()
        );
    }

    public static Customer mapToCustomer(CustomerDTO dto) {
        return new Customer(
                dto.getId(),
                dto.getCustomerId(),
                dto.getPhoneNumber(),
                dto.getEmail(),
                dto.getAddress()
        );
    }

    public static Account mapToAccount(CustomerDTO dto) {
        return new Account(
                dto.getAccountNumber(),
                dto.getAccountType(),
                dto.getAccountName(),
                dto.getAccountBalance()
        );
    }

}
