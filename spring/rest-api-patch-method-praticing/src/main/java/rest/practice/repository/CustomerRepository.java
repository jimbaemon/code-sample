package rest.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.practice.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
