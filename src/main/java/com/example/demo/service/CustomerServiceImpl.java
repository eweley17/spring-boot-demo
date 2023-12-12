package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.AccountDAO;
import com.example.demo.dao.CustomerDAO;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private AccountDAO accountDAO;

	@Override
	public List<CustomerDTO> getAllDetails() {
		List<CustomerDTO> list = new ArrayList<>();
		List<Customer> customerList = customerDAO.findAll();
		List<Account> accountList = accountDAO.findAll();
		for (Customer customer : customerList) {
			Account account = accountList.parallelStream().filter(c -> c.getId().equals(customer.getAccount().getId())).findAny().orElse(null);
			if (account != null) {
				list.add(CustomerMapper.mapToCustomerDTO(customer, account));
			}
		}
		return list;
	}

	@Override
	public CustomerDTO getDetailById(Long id) {
		Customer customer = customerDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer is not exist with given ID: " + id));
		Account account = accountDAO.findById(customer.getAccount().getId()).orElseThrow(() -> new ResourceNotFoundException("Account is not exist withh given ID: " + customer.getAccount().getId()));
		return CustomerMapper.mapToCustomerDTO(customer, account);
    }

	@Transactional(readOnly = false)
	public CustomerDTO create(CustomerDTO dto) {
		Account account = new Account();
		account.setAccountNumber(dto.getAccountNumber());
		account.setAccountType(dto.getAccountType());
		account.setAccountName(dto.getAccountName());
		account.setAccountBalance(dto.getAccountBalance());
		Account savedAccount = accountDAO.save(account);
		
		Customer customer = new Customer();
		customer.setCustomerId(dto.getCustomerId());
		customer.setPhoneNumber(dto.getPhoneNumber());
		customer.setEmail(dto.getEmail());
		customer.setAddress(dto.getAddress());
		customer.setAccount(account);
		Customer savedCustomer = customerDAO.save(customer);
		
		return CustomerMapper.mapToCustomerDTO(savedCustomer, savedAccount);
	}

	@Transactional(readOnly = false)
	public CustomerDTO update(CustomerDTO dto) {
		Customer customer = customerDAO.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException("Customer is not exist with given ID: " + dto.getId()));
		customer.setCustomerId(dto.getCustomerId());
		customer.setPhoneNumber(dto.getPhoneNumber());
		customer.setEmail(dto.getEmail());
		customer.setAddress(dto.getAddress());
		Customer savedCustomer = customerDAO.save(customer);

		Account account = accountDAO.findById(customer.getAccount().getId()).orElseThrow(() -> new ResourceNotFoundException("Account is not exist with given ID: " + customer.getAccount().getId()));
		account.setAccountNumber(dto.getAccountNumber());
		account.setAccountType(dto.getAccountType());
		account.setAccountName(dto.getAccountName());
		account.setAccountBalance(dto.getAccountBalance());
		Account savedAccount = accountDAO.save(account);

		return CustomerMapper.mapToCustomerDTO(savedCustomer, savedAccount);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		Customer customer = customerDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer is not exist with given ID: " + id));
		Account account = accountDAO.findById(customer.getAccount().getId()).orElseThrow(() -> new ResourceNotFoundException("Account is not exist with given ID: " + customer.getAccount().getId()));

		customerDAO.delete(customer);
		accountDAO.delete(account);
	}
	
}
