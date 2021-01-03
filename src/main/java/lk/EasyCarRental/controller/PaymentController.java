package lk.EasyCarRental.controller;

import lk.EasyCarRental.dto.PaymentDTO;
import lk.EasyCarRental.service.PaymentService;
import lk.EasyCarRental.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@CrossOrigin
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping
    public ResponseEntity saveDriver(@RequestBody PaymentDTO paymentDTO){
        paymentService.savePayment(paymentDTO);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateDriver(@RequestBody PaymentDTO paymentDTO){
        paymentService.updatePayment(paymentDTO);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null),HttpStatus.OK);
    }
    @DeleteMapping(params = {"paymentId"})
    public ResponseEntity deleteDriver(@RequestParam String driverId){
        paymentService.deletePayment(driverId);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{paymentId}")
    public ResponseEntity searchById(@PathVariable String paymentId){
        PaymentDTO paymentDTO=paymentService.searchPaymentById(paymentId);
        return new ResponseEntity(new StandedResponse(200,"Sucess",paymentDTO),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllDriver(){
        List<PaymentDTO> allDrivers= paymentService.getAllPayment();
        return new ResponseEntity(new StandedResponse(200,"Sucess",allDrivers),HttpStatus.OK);

    }
}
