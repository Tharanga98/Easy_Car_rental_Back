package lk.EasyCarRental.repository;


import lk.EasyCarRental.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver,String> {
}
