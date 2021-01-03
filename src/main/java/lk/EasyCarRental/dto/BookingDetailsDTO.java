package lk.EasyCarRental.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingDetailsDTO {

    private String bookingDetailsId;
    private boolean driverRequirde;
    private double meterValue;
    private String description;

    public String getBookingDetailsId() {
        return bookingDetailsId;
    }

    public void setBookingDetailsId(String bookingDetailsId) {
        this.bookingDetailsId = bookingDetailsId;
    }

    public boolean isDriverRequirde() {
        return driverRequirde;
    }

    public void setDriverRequirde(boolean driverRequirde) {
        this.driverRequirde = driverRequirde;
    }

    public double getMeterValue() {
        return meterValue;
    }

    public void setMeterValue(double meterValue) {
        this.meterValue = meterValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
