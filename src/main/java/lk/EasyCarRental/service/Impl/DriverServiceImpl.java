package lk.EasyCarRental.service.Impl;

import lk.EasyCarRental.dto.DriverDTO;
import lk.EasyCarRental.entity.Driver;
import lk.EasyCarRental.repository.DriverRepository;
import lk.EasyCarRental.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    DriverRepository driverRepository;

    @Override
    public void saveDriver(DriverDTO driverDTO) {
        if(!driverRepository.existsById(driverDTO.getDriverId())){
            Driver driver=modelMapper.map(driverDTO, Driver.class);
            driverRepository.save(driver);
        }else{
            throw new RuntimeException("Driver is all ready exist by id "+driverDTO.getDriverId());
        }
    }

    @Override
    public void updateDriver(DriverDTO driverDTO) {
        if(driverRepository.existsById(driverDTO.getDriverId())){
            Driver driver=modelMapper.map(driverDTO,Driver.class);
            driverRepository.save(driver);
        }else{
            throw  new RuntimeException("Driver is not exist for update by id "+driverDTO.getDriverId());
        }
    }

    @Override
    public void deleteDriver(String driverId) {
        if(driverRepository.existsById(driverId)){
           driverRepository.deleteById(driverId);
        }else{
            throw new RuntimeException("Driver is not exist by id "+driverId);
        }
    }

    @Override
    public DriverDTO searchDriverById(String driverId) {
        Optional<Driver> driver= driverRepository.findById(driverId);
       if(driver.isPresent()){
         return  modelMapper.map(driver.get(),DriverDTO.class);
       }else{
           throw new RuntimeException("Can not find Driver for this id ");
       }
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        List<Driver> driver=driverRepository.findAll();
       return  modelMapper.map(driver,new TypeToken<List<DriverDTO>>(){}.getType());
    }
}
