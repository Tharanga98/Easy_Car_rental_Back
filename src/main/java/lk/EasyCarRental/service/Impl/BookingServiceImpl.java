package lk.EasyCarRental.service.Impl;

import lk.EasyCarRental.dto.BookingDTO;
import lk.EasyCarRental.entity.Booking;
import lk.EasyCarRental.repository.BookingRepository;
import lk.EasyCarRental.service.BookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public void saveBooking(BookingDTO bookingDTO) {
        if (!bookingRepository.existsById(bookingDTO.getBookingId())) {
            Booking booking = modelMapper.map(bookingDTO, Booking.class);
            bookingRepository.save(booking);
        } else {
            throw new RuntimeException("booking is all ready exist by id " + bookingDTO.getBookingId());
        }
    }

    @Override
    public void updateBooking(BookingDTO bookingDTO) {
        if (bookingRepository.existsById(bookingDTO.getBookingId())) {
            Booking booking = modelMapper.map(bookingDTO, Booking.class);
            bookingRepository.save(booking);
        } else {
            throw new RuntimeException("booking is all ready exist by id " + bookingDTO.getBookingId());
        }
    }

    @Override
    public void deleteBooking(String bookingId) {
        if (bookingRepository.existsById(bookingId)) {
            bookingRepository.deleteById(bookingId);
        } else {
            throw new RuntimeException("Booking is not exist by id " + bookingId);
        }
    }

    @Override
    public BookingDTO searchById(String bookingId) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if (booking.isPresent()) {
            return modelMapper.map(booking.get(), BookingDTO.class);
        } else {
            throw new RuntimeException("Can not find Order for this id ");
        }
    }

    @Override
    public List<BookingDTO> getAllBooking() {
        List<Booking> allBooking = bookingRepository.findAll();
        return modelMapper.map(allBooking, new TypeToken<List<BookingDTO>>() {
        }.getType());
    }
}