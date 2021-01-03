package lk.EasyCarRental.controller;

import lk.EasyCarRental.dto.LossDamageDTO;
import lk.EasyCarRental.service.LossDamageService;
import lk.EasyCarRental.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lossDamage")
@CrossOrigin
public class LossDamageController{

    @Autowired
    LossDamageService lossDamageService;

    @PostMapping
    public ResponseEntity saveDriver(@RequestBody LossDamageDTO lossDamageDTO){
        lossDamageService.saveLostDamage(lossDamageDTO);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateDriver(@RequestBody LossDamageDTO lossDamageDTO){
        lossDamageService.updateLostDamage( lossDamageDTO);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null),HttpStatus.OK);
    }
    @DeleteMapping(params = {"lossDamageId"})
    public ResponseEntity deleteDriver(@RequestParam String lossDamageId){
        lossDamageService.deleteLostDamage(lossDamageId);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{lossDamageId}")
    public ResponseEntity searchById(@PathVariable String lossDamageId){
        LossDamageDTO lossDamageDTO=lossDamageService.searchLostDamageById(lossDamageId);
        return new ResponseEntity(new StandedResponse(200,"Sucess",lossDamageDTO),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllDriver(){
        List<LossDamageDTO> allLossDamage= lossDamageService.getAllLostDamage();
        return new ResponseEntity(new StandedResponse(200,"Sucess",allLossDamage),HttpStatus.OK);

    }
}
