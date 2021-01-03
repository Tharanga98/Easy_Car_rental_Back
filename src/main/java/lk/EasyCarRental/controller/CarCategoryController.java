package lk.EasyCarRental.controller;


import lk.EasyCarRental.dto.CarCategoryDTO;
import lk.EasyCarRental.service.CarCategoryService;
import lk.EasyCarRental.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CarCategoryController {

    @Autowired
    CarCategoryService carCategoryService;

    @PostMapping
    public ResponseEntity addCarCategory(@RequestBody CarCategoryDTO carCategoryDTO){
        carCategoryService.saveCategory(carCategoryDTO);
        StandedResponse response=new StandedResponse(200,"Sccess",null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateCar(@RequestBody CarCategoryDTO carCategoryDTO){
        carCategoryService.updateCategory(carCategoryDTO);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null),HttpStatus.OK);
    }

    @DeleteMapping(params = {"categoryId"})
    public ResponseEntity deleteCar(@RequestParam String categoryId){
        carCategoryService.deleteCategory(categoryId);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{categoryId}")
    public ResponseEntity searchCar(@PathVariable String categoryId){
        CarCategoryDTO carCategoryDTO = carCategoryService.searchById(categoryId);
        return new ResponseEntity(new StandedResponse(200,"Sucess", carCategoryDTO),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllCar(){
        List<CarCategoryDTO> allcar= carCategoryService.getAllCategory();
        return new ResponseEntity(new StandedResponse(200,"Sucess",allcar),HttpStatus.OK);

    }
}
