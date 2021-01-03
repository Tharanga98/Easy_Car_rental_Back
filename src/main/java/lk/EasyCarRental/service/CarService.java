package lk.EasyCarRental.service;

import lk.EasyCarRental.dto.CarDTO;

import java.util.List;

public interface CarService {

    void saveCar(CarDTO carDTO);

    void updateCar(CarDTO carDTO);

    void deleteCar(String carDAO);

    CarDTO searchById(String carDAO);

    List<CarDTO> getAllcar();
}
