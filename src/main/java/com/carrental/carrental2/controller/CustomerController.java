package com.carrental.carrental2.controller;

import com.carrental.carrental2.dto.CustomerDTO;
import com.carrental.carrental2.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PreAuthorize("hasAnyRole('SUPERADMIN' ,'ADMIN')")
    @PostMapping
    public ResponseEntity<CustomerDTO> create(@Validated @RequestBody CustomerDTO dto) {
        return new ResponseEntity<>(service.createCustomer(dto), HttpStatus.CREATED);
    }
    @PreAuthorize("hasAnyRole('SUPERADMIN' ,'ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCustomerById(id));
    }
    @PreAuthorize("hasAnyRole('SUPERADMIN' ,'ADMIN')")
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAll() {
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @PreAuthorize("hasAnyRole('SUPERADMIN' ,'ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> update(@PathVariable Long id, @Validated @RequestBody CustomerDTO dto) {
        return ResponseEntity.ok(service.updateCustomer(id, dto));
    }
    @PreAuthorize("hasAnyRole('SUPERADMIN' ,'ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
