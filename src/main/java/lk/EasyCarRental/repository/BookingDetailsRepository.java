package lk.EasyCarRental.repository;

import lk.EasyCarRental.entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails,String> {
}
