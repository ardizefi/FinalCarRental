package com.carrental.carrental2.services;

import com.carrental.carrental2.dto.CarDTO;
import com.carrental.carrental2.model.Car;
import com.carrental.carrental2.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    @Override
    public CarDTO createCar(CarDTO carDTO) {
        Car car = new Car(carDTO.getId() , carDTO.getColor(), carDTO.getBrand(), carDTO.getModel(), carDTO.getYear(), carDTO.getPrice(), carDTO.getTransmission(), carDTO.getFuelType(),carDTO.getStatus());
        Car saved = carRepository.save(car);

        return new CarDTO(saved.getId(), saved.getBrand(), saved.getModel(), saved.getColor(), saved.getYear() , saved.getPrice(), saved.getTransmission(), saved.getFuelType(), saved.getStatus());
    }
    @Override
    public CarDTO updateCar(Long id, CarDTO carDTO){
        Car existing = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        existing.setBrand(carDTO.getBrand());
        existing.setModel(carDTO.getModel());
        existing.setColor(carDTO.getColor());
        existing.setYear(carDTO.getYear());
        existing.setPrice(carDTO.getPrice());
        existing.setTransmission(carDTO.getTransmission());
        existing.setFuelType(carDTO.getFuelType());
        existing.setStatus(carDTO.getStatus());

        Car updated = carRepository.save(existing);
        return new CarDTO (updated.getId(), updated.getBrand(), updated.getModel(), updated.getColor(), updated.getYear(), updated.getPrice(), updated.getTransmission(), carDTO.getFuelType(), updated.getStatus());
    }
    @Override
    public void deleteCar(Long id){
        carRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Car not found"));
        carRepository.deleteById(id);
    }

    @Override
    public List<CarDTO> getAllCars() {
        return carRepository.findAll().stream()
                .map(car -> new CarDTO(car.getId(),car.getBrand(), car.getModel(), car.getColor(), car.getYear(), car.getPrice(), car.getTransmission(), car.getFuelType(), car.getStatus()))
                .collect(Collectors.toList());

    }


    @Override
    public CarDTO getCarById(Long id){
        Car c = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));
        return new CarDTO(c.getId(),c.getBrand(), c.getModel(), c.getColor(), c.getYear(), c.getPrice(), c.getTransmission(), c.getFuelType(), c.getStatus());

    }

}
