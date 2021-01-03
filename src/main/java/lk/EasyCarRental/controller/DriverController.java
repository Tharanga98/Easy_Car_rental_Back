package lk.EasyCarRental.controller;

import lk.EasyCarRental.dto.DriverDTO;
import lk.EasyCarRental.service.DriverService;
import lk.EasyCarRental.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping
    public ResponseEntity saveDriver(@RequestBody DriverDTO driverDTO){
        driverService.saveDriver(driverDTO);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateDriver(@RequestBody DriverDTO driverDTO){
        driverService.updateDriver(driverDTO);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null),HttpStatus.OK);
    }
    @DeleteMapping(params = {"driverId"})
    public ResponseEntity deleteDriver(@RequestParam String driverId){
        driverService.deleteDriver(driverId);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{driverId}")
    public ResponseEntity searchById(@PathVariable String driverId){
        DriverDTO driverDTO=driverService.searchDriverById(driverId);
        return new ResponseEntity(new StandedResponse(200,"Sucess",driverDTO),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllDriver(){
        List<DriverDTO> allDrivers= driverService.getAllDrivers();
        return new ResponseEntity(new StandedResponse(200,"Sucess",allDrivers),HttpStatus.OK);

    }
}
