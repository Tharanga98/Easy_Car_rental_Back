package lk.EasyCarRental.service;

import lk.EasyCarRental.dto.BookingDetailsDTO;

import java.util.List;

public interface BookingDetailsService {

    void saveBookingDetails(BookingDetailsDTO bookingDetailsDTO);

    void updateBookingDetails(BookingDetailsDTO bookingDetailsDTO);

    void deleteBookingDetails(String bookingDetailsId);

    BookingDetailsDTO searchById(String bookingDetailsId);

    List<BookingDetailsDTO> getAllBookingDetails();
}
