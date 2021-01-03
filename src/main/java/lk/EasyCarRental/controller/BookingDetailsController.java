package lk.EasyCarRental.controller;

import lk.EasyCarRental.dto.BookingDTO;
import lk.EasyCarRental.dto.BookingDetailsDTO;
import lk.EasyCarRental.entity.BookingDetails;
import lk.EasyCarRental.service.BookingDetailsService;
import lk.EasyCarRental.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookingdetails")
@CrossOrigin
public class BookingDetailsController {

    @Autowired
    BookingDetailsService bookingDetailsService;

    @PostMapping
    public ResponseEntity addOrder(@RequestBody BookingDetailsDTO bookingDetailsDTO){
        bookingDetailsService.saveBookingDetails(bookingDetailsDTO);
        StandedResponse response=new StandedResponse(200,"Sccess",null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateOrder(@RequestBody BookingDetailsDTO bookingDetailsDTO){
        bookingDetailsService.updateBookingDetails(bookingDetailsDTO);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null),HttpStatus.OK);
    }

    @DeleteMapping(params = {"bookingDetailsId"})
    public ResponseEntity deleteOrder(@RequestParam String bookingDetailsId){
        bookingDetailsService.deleteBookingDetails(bookingDetailsId);
        return new ResponseEntity(new StandedResponse(200,"Sucess",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{bookingDetailsId}")
    public ResponseEntity searchOrder(@PathVariable String bookingDetailsId){
        BookingDetailsDTO  bookingDetailsDTO = bookingDetailsService.searchById(bookingDetailsId);
        return new ResponseEntity(new StandedResponse(200,"Sucess", bookingDetailsId),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllBookingDetails(){
        List<BookingDetailsDTO> allOrder= bookingDetailsService.getAllBookingDetails();
        return new ResponseEntity(new StandedResponse(200,"Sucess",allOrder),HttpStatus.OK);

    }
}
