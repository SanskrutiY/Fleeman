package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.CustomerDTO;
import service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
		List<CustomerDTO> custDto = customerService.getAllCustomers();
		return ResponseEntity.ok(custDto);
	}
}
