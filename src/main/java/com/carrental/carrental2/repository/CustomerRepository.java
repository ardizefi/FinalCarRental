package com.carrental.carrental2.repository;

import com.carrental.carrental2.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
