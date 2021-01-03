package lk.EasyCarRental.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookingDetails {

    @Id
    private String bookingDetailsId;
    private boolean driverRequirde;
    private double meterValue;
    private String description;


}
