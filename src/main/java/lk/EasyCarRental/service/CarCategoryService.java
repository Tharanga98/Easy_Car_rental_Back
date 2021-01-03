package lk.EasyCarRental.service;

import lk.EasyCarRental.dto.CarCategoryDTO;
import lk.EasyCarRental.dto.CarDTO;
import lk.EasyCarRental.entity.CarCategory;

import java.util.List;

public interface CarCategoryService {

    void saveCategory(CarCategoryDTO carCategoryDTO);

    void updateCategory(CarCategoryDTO carCategoryDTO);

    void deleteCategory(String carCategoryId);

    CarCategoryDTO searchById(String carCategoryId);

    List<CarCategoryDTO> getAllCategory();
}
