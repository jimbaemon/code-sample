package rest.practice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rest.practice.controller.dto.CustomerDTO;
import rest.practice.domain.Customer;
import rest.practice.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {

	private final CustomerRepository customerRepository;

	public Optional<Customer> findCustomer(Long id) {
		return customerRepository.findById(id);
	}

	public void updateCustomer(Customer customerPatched) {
		customerRepository.save(customerPatched);
	}

	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
}
