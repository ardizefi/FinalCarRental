package com.carrental.carrental2.controller;

import com.carrental.carrental2.dto.CarDTO;
import com.carrental.carrental2.services.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @PreAuthorize("hasAnyRole('SUPERADMIN' ,'ADMIN')")
    @PostMapping
    public ResponseEntity<CarDTO> create(@Validated @RequestBody CarDTO dto) {
        return new ResponseEntity<>(service.createCar(dto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('SUPERADMIN' ,'ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCarById(id));
    }

    @PreAuthorize("hasAnyRole('SUPERADMIN' ,'ADMIN')")
    @GetMapping
    public ResponseEntity<List<CarDTO>> getAll() {
        return ResponseEntity.ok(service.getAllCars());
    }

    @PreAuthorize("hasAnyRole('SUPERADMIN' ,'ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CarDTO> update(@PathVariable Long id, @Validated @RequestBody CarDTO dto) {
        return ResponseEntity.ok(service.updateCar(id, dto));
    }
    @PreAuthorize("hasAnyRole('SUPERADMIN' ,'ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

}
