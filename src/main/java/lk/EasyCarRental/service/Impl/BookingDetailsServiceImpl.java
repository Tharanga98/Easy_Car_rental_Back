package lk.EasyCarRental.service.Impl;


import lk.EasyCarRental.dto.BookingDetailsDTO;
import lk.EasyCarRental.entity.BookingDetails;
import lk.EasyCarRental.repository.BookingDetailsRepository;
import lk.EasyCarRental.service.BookingDetailsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingDetailsServiceImpl implements BookingDetailsService {

    @Autowired
    BookingDetailsRepository bookingDetailsRepository;
    @Autowired
    ModelMapper modelMapper;


    @Override
    public void saveBookingDetails(BookingDetailsDTO bookingDetailsDTO) {
        if (!bookingDetailsRepository.existsById(bookingDetailsDTO.getBookingDetailsId())) {
            BookingDetails bookingDetails = modelMapper.map(bookingDetailsDTO, BookingDetails.class);
            bookingDetailsRepository.save(bookingDetails);
        } else {
            throw new RuntimeException("booking is all ready exist by id " + bookingDetailsDTO.getBookingDetailsId());
        }
    }

    @Override
    public void updateBookingDetails(BookingDetailsDTO bookingDetailsDTO) {
        if (!bookingDetailsRepository.existsById(bookingDetailsDTO.getBookingDetailsId())) {
            BookingDetails bookingDetails = modelMapper.map(bookingDetailsDTO, BookingDetails.class);
            bookingDetailsRepository.save(bookingDetails);
        } else {
            throw new RuntimeException("booking is all ready exist by id " + bookingDetailsDTO.getBookingDetailsId());
        }
    }

    @Override
    public void deleteBookingDetails(String bookingDetailsId) {
        if (bookingDetailsRepository.existsById(bookingDetailsId)) {
            bookingDetailsRepository.deleteById(bookingDetailsId);
        } else {
            throw new RuntimeException("Booking is not exist by id " + bookingDetailsId);
        }
    }

    @Override
    public BookingDetailsDTO searchById(String bookingDetailsId) {
        Optional<BookingDetails> bookingDetails = bookingDetailsRepository.findById(bookingDetailsId);
        if (bookingDetails.isPresent()) {
            return modelMapper.map(bookingDetails.get(), BookingDetailsDTO.class);
        } else {
            throw new RuntimeException("Can not find Order for this id ");
        }
    }

    @Override
    public List<BookingDetailsDTO> getAllBookingDetails() {
        List<BookingDetails> allBookingDetails = bookingDetailsRepository.findAll();
        return modelMapper.map(allBookingDetails, new TypeToken<List<BookingDetailsDTO>>() {
        }.getType());
    }
}
