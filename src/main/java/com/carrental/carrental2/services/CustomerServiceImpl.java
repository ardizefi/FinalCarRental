package com.carrental.carrental2.services;

import com.carrental.carrental2.dto.CustomerDTO;
import com.carrental.carrental2.model.Customer;
import com.carrental.carrental2.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customer -> new CustomerDTO(customer.getId(),customer.getName(), customer.getLastName(), customer.getEmail(), customer.getPhoneNumber()))
                .collect(Collectors.toList());

    }
    @Override
    public CustomerDTO getCustomerById(Long id){
        Customer c = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return new CustomerDTO(c.getId(),c.getName(), c.getLastName(),c.getEmail(), c.getPhoneNumber());

    }
    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO.getId() , customerDTO.getName() ,customerDTO.getLastName() ,customerDTO.getEmail(),customerDTO.getPhoneNumber());
        Customer saved = customerRepository.save(customer);

        return new CustomerDTO(saved.getId(),saved.getName(),saved.getLastName(),saved.getEmail(),saved.getPhoneNumber());
    }
    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO){
        Customer existing = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        existing.setId(customerDTO.getId());
        existing.setEmail(customerDTO.getEmail());
        existing.setLastName(customerDTO.getLastName());
        existing.setName(customerDTO.getName());
        existing.setPhoneNumber( customerDTO.getPhoneNumber());

        Customer updated = customerRepository.save(existing);
        return new CustomerDTO (updated.getId(),updated.getName(),updated.getLastName(),updated.getEmail(),updated.getPhoneNumber());
    }
    @Override
    public void deleteCustomer(Long id){
        customerRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Customer not found"));
        customerRepository.deleteById(id);
    }
}
