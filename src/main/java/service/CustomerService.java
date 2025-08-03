package service;

import java.util.List;

import dto.CustomerDTO;

public interface CustomerService {
	 List<CustomerDTO> getAllCustomers();
	 CustomerDTO getCustomerById(int custId);
	 CustomerDTO createCustomer(CustomerDTO customerDTO);
	 CustomerDTO updateCustomer(int custId, CustomerDTO customerDTO);
	 void deleteCustomer(int custId);
}
