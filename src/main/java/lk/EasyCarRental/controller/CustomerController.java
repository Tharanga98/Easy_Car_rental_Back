package lk.EasyCarRental.controller;



import lk.EasyCarRental.dto.CustomerDTO;
import lk.EasyCarRental.service.CustomerService;
import lk.EasyCarRental.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        StandedResponse response=new StandedResponse(200,"Sccess",null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerDTO);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null),HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCustomer(@RequestParam String id){
        customerService.deleteCustomer(id);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchCustomer(@PathVariable String id){
        CustomerDTO customerDTO = customerService.searchCustomer(id);
        return new ResponseEntity(new StandedResponse(200,"Sucess", customerDTO),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllCustomer(){
        List<CustomerDTO> allCustomer= customerService.getAllCustomer();
        return new ResponseEntity(new StandedResponse(200,"Sucess",allCustomer),HttpStatus.OK);

    }
}