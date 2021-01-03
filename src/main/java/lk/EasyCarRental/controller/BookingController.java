package lk.EasyCarRental.controller;


import lk.EasyCarRental.dto.BookingDTO;
import lk.EasyCarRental.service.BookingService;
import lk.EasyCarRental.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@CrossOrigin
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping
    public ResponseEntity addOrder(@RequestBody BookingDTO bookingDTO){
        bookingService.saveBooking(bookingDTO);
        StandedResponse response=new StandedResponse(200,"Sccess",null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateOrder(@RequestBody BookingDTO bookingDTO){
        bookingService.updateBooking(bookingDTO);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null),HttpStatus.OK);
    }

    @DeleteMapping(params = {"bookingId"})
    public ResponseEntity deleteOrder(@RequestParam String bookingId){
        bookingService.deleteBooking(bookingId);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{bookingId}")
    public ResponseEntity searchOrder(@PathVariable String orderId){
        BookingDTO orderDTO = bookingService.searchById(orderId);
        return new ResponseEntity(new StandedResponse(200,"Sucess", orderDTO),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllOrder(){
        List<BookingDTO> allOrder= bookingService.getAllBooking();
        return new ResponseEntity(new StandedResponse(200,"Sucess",allOrder),HttpStatus.OK);

    }
}
