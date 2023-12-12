package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	//getalldetails
	@GetMapping(value = "/getalldetails")
	public ResponseEntity<List<CustomerDTO>> getalldetails(Integer page, Integer pageLength) {
		List<CustomerDTO> list = customerService.getAllDetails(page, pageLength);
		return ResponseEntity.ok(list);
	}
	
	//getdetailById
	@GetMapping(value = "/getdetailById")
	public ResponseEntity<CustomerDTO> getdetailById (Long id) {
		CustomerDTO customerDTO = customerService.getDetailById(id);
		return ResponseEntity.ok(customerDTO);
	}
	
	//create
	@PostMapping(value = "/create")
	public ResponseEntity<CustomerDTO> create (@RequestBody CustomerDTO dto) throws Exception {
		return new ResponseEntity<>(customerService.create(dto), HttpStatus.CREATED);
	}
	
	//update
	@PatchMapping(value = "/update")
	public ResponseEntity<CustomerDTO> update (@RequestBody CustomerDTO dto) throws Exception {
		CustomerDTO customerDTO = customerService.update(dto);
		return ResponseEntity.ok(customerDTO);
	}
	
	//delete
	@DeleteMapping(value = "/delete")
	public ResponseEntity<String> delete (HttpServletRequest request, HttpServletResponse response, Long id) throws Exception {
		customerService.delete(id);
		return ResponseEntity.ok("Customer deleted successfully.");
	}
	
}
