package lk.EasyCarRental.service;

import lk.EasyCarRental.dto.DriverDTO;

import java.util.List;

public interface DriverService {

    void saveDriver(DriverDTO driverDTO);

    void updateDriver(DriverDTO driverDTO);

    void deleteDriver(String driverId);

    DriverDTO  searchDriverById(String driverId);

    List<DriverDTO> getAllDrivers();
}
