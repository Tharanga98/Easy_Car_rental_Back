package lk.EasyCarRental.repository;

import lk.EasyCarRental.entity.CarCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarCategoryRepository extends JpaRepository<CarCategory,String> {
}
