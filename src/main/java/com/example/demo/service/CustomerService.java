package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CustomerDTO;

public interface CustomerService {

	public List<CustomerDTO> getAllDetails();

	public CustomerDTO getDetailById(Long id);

	public CustomerDTO create(CustomerDTO dto);

	public CustomerDTO update(CustomerDTO dto);

	public void delete(Long id);

}
