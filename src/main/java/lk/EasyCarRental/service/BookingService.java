package lk.EasyCarRental.service;

import lk.EasyCarRental.dto.BookingDTO;

import java.util.List;

public interface BookingService {

    void saveBooking(BookingDTO bookingDTO);

    void updateBooking(BookingDTO bookingDTO);

    void deleteBooking(String bookingId);

    BookingDTO searchById(String bookingId);

    List<BookingDTO> getAllBooking();
}
