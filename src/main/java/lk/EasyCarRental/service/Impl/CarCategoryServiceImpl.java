package lk.EasyCarRental.service.Impl;

import lk.EasyCarRental.dto.CarCategoryDTO;
import lk.EasyCarRental.entity.CarCategory;
import lk.EasyCarRental.repository.CarCategoryRepository;
import lk.EasyCarRental.service.CarCategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarCategoryServiceImpl implements CarCategoryService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CarCategoryRepository carCategoryRepository;

    @Override
    public void saveCategory(CarCategoryDTO carCategoryDTO) {
        if(!carCategoryRepository.existsById(carCategoryDTO.getCategoryId())){
            CarCategory carCategory=modelMapper.map(carCategoryDTO, CarCategory.class);
            carCategoryRepository.save(carCategory);
        }else{
            throw new RuntimeException("Car Category is Allredy exist by "+ carCategoryDTO.getCategoryId());
        }
    }

    @Override
    public void updateCategory(CarCategoryDTO carCategoryDTO) {
        if(carCategoryRepository.existsById(carCategoryDTO.getCategoryId())){
            CarCategory carCategory=modelMapper.map(carCategoryDTO, CarCategory.class);
            carCategoryRepository.save(carCategory);
        }else{
            throw new RuntimeException("Car Category is Allredy exist by "+ carCategoryDTO.getCategoryId());
        }
    }

    @Override
    public void deleteCategory( String carCategoryId) {
        if(carCategoryRepository.existsById(carCategoryId)){
            carCategoryRepository.deleteById(carCategoryId);
        }else{
            throw new RuntimeException("No car Category  Delete by this ID - "+carCategoryId);
        }
    }

    @Override
    public CarCategoryDTO searchById(String carCategoryId) {
        Optional<CarCategory> carCategory =  carCategoryRepository.findById(carCategoryId);
        if(carCategory.isPresent()){
            return  modelMapper.map(carCategory.get(), CarCategoryDTO.class);
        }else{
            throw new RuntimeException("No car Found.....");
        }
    }

    @Override
    public List<CarCategoryDTO> getAllCategory() {
        List<CarCategory> allCarCategory = carCategoryRepository.findAll();
        return modelMapper.map(allCarCategory,new TypeToken<List<CarCategoryDTO>>(){}.getType());
    }
}
