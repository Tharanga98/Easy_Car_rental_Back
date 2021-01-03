package lk.EasyCarRental.repository;

import lk.EasyCarRental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository  extends JpaRepository<Car,String> {
}
