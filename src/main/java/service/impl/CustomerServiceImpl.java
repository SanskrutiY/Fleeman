package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.CustomerDTO;
import entity.Customer;
import mapper.Mapper;
import repository.CustomerRepository;
import service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	   
	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> customerList = customerRepo.findAll();
        List<CustomerDTO> customerDtoList = new ArrayList<>();
        for (Customer customers : customerList) {
        	customerDtoList.add(Mapper.mapToCustomerDTO(customers));
        }
        return customerDtoList;
	}

	@Override
	public CustomerDTO getCustomerById(int custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO createCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO updateCustomer(int custId, CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomer(int custId) {
		// TODO Auto-generated method stub
		
	}

}

