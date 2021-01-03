package lk.EasyCarRental.controller;


import lk.EasyCarRental.dto.CarDTO;
import lk.EasyCarRental.service.CarService;
import lk.EasyCarRental.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping
    public ResponseEntity addCar(@RequestBody CarDTO carDTO){
        carService.saveCar(carDTO);
        StandedResponse response=new StandedResponse(200,"Sccess",null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateCar(@RequestBody CarDTO carDTO){
        carService.updateCar(carDTO);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null),HttpStatus.OK);
    }

    @DeleteMapping(params = {"carId"})
    public ResponseEntity deleteCar(@RequestParam String carId){
        carService.deleteCar(carId);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{carId}")
    public ResponseEntity searchCar(@PathVariable String carId){
        CarDTO carDTO = carService.searchById(carId);
        return new ResponseEntity(new StandedResponse(200,"Sucess", carDTO),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllCar(){
        List<CarDTO> allcar= carService.getAllcar();
        return new ResponseEntity(new StandedResponse(200,"Sucess",allcar),HttpStatus.OK);

    }
}
