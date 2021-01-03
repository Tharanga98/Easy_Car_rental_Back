package lk.EasyCarRental.repository;

import lk.EasyCarRental.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository  extends JpaRepository<Booking,String>{
}
