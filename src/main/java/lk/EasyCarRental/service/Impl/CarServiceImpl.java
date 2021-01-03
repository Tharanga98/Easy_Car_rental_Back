package lk.EasyCarRental.service.Impl;

import lk.EasyCarRental.dto.CarDTO;
import lk.EasyCarRental.entity.Car;
import lk.EasyCarRental.repository.CarRepository;
import lk.EasyCarRental.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveCar(CarDTO carDTO) {
        if(!carRepository.existsById(carDTO.getCarId())){
            Car car=modelMapper.map(carDTO, Car.class);
            carRepository.save(car);
        }else{
            throw new RuntimeException("Car is Allredy exist by "+ carDTO.getCarId());
        }
    }

    @Override
    public void updateCar(CarDTO carDTO) {
        if(carRepository.existsById(carDTO.getCarId())){
            Car car=modelMapper.map(carDTO, Car.class);
            carRepository.save(car);
        }else{
            throw new RuntimeException("Car is Allredy exist by "+ carDTO.getCarId());
        }
    }

    @Override
    public void deleteCar(String carId) {
        if(carRepository.existsById(carId)) {
            carRepository.deleteById(carId);
        }else{
            throw new RuntimeException("No car Delete by this ID - "+carId);
        }
    }

    @Override
    public CarDTO searchById(String carId) {
        Optional<Car> car = carRepository.findById(carId);
        if(car.isPresent()){
            return  modelMapper.map(car.get(), CarDTO.class);
        }else{
            throw new RuntimeException("No car Found.....");
        }
    }

    @Override
    public List<CarDTO> getAllcar() {
        List<Car> allCar = carRepository.findAll();
        return modelMapper.map(allCar,new TypeToken<List<CarDTO>>(){}.getType());
    }
}
