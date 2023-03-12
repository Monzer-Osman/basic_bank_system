package com.MIS.basic_banking_system.Customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityNotFoundException;


@Data
@Slf4j
@Service
@AllArgsConstructor
public class CustomerService{
	private CustomerRepository customerRepository;

	public List<Customer> getAll(){
		return customerRepository.findAll();
	}

	public Customer getCustomerById(Integer customerId) throws Exception{
		return customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Category not found!"));
	}

	public void addCustomer(Customer customer){
		customerRepository.save(customer);
	}

	public void justCreateNew(String firstName, String lastName, String email, Long balance) {
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setBalance(balance);
		customerRepository.save(customer);
	}

	public void updateCustomer(Integer customerId, Customer customer){
		Optional<Customer> curCustomer = customerRepository.findById(customerId);
		curCustomer.ifPresent( tmpCustomer -> tmpCustomer = customer);
		customerRepository.save(curCustomer.get());
	}

	public void deleteCustomer(Customer customer){
		customerRepository.delete(customer);
	}

}