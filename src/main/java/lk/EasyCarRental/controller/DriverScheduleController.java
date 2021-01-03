package lk.EasyCarRental.controller;

import lk.EasyCarRental.dto.DriverScheduleDTO;
import lk.EasyCarRental.service.DriverScheduleService;
import lk.EasyCarRental.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driverschedule")
@CrossOrigin
public class DriverScheduleController {

    @Autowired
    DriverScheduleService driverScheduleService;

    @PostMapping
    public ResponseEntity saveDriverSchedule(@RequestBody DriverScheduleDTO driverScheduleDTO){
        driverScheduleService.saveDriverSchedule(driverScheduleDTO);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateDriverSchedule(@RequestBody DriverScheduleDTO driverScheduleDTO){
        driverScheduleService.updateDriverSchedule(driverScheduleDTO);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null),HttpStatus.OK);
    }
    @DeleteMapping(params = {"scheduleId"})
    public ResponseEntity deleteDriverSchedule(@RequestParam String driverScheduleId){
        driverScheduleService.deleteDriverSchedule(driverScheduleId);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{scheduleId}")
    public ResponseEntity searchByIdDriverSchedule(@PathVariable String driverScheduleId){
        DriverScheduleDTO driverScheduleDTO=driverScheduleService.searchDriverScheduleById(driverScheduleId);
        return new ResponseEntity(new StandedResponse(200,"Sucess",driverScheduleDTO),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllDriverSchedule(){
        List<DriverScheduleDTO> allDriverSchedule= driverScheduleService.getAllDriversSchedule();
        return new ResponseEntity(new StandedResponse(200,"Sucess",allDriverSchedule),HttpStatus.OK);

    }

}
