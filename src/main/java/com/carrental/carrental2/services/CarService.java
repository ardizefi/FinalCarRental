package com.carrental.carrental2.services;

import com.carrental.carrental2.dto.CarDTO;

import java.util.List;

public interface CarService {
    CarDTO createCar (CarDTO dto);
    CarDTO getCarById(Long id);
    List<CarDTO> getAllCars();
    CarDTO updateCar(Long id, CarDTO dto);
    void deleteCar(Long id);

}
