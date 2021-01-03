package lk.EasyCarRental.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @Id
     private String customerId;
     private String name;
     private String email;
     private String password;
     private String address;
     private String contactNumber;
     private String nicNumber;
     private boolean verified;
     private Date registedDateTime;
     private String nicImg;
     private String customerImg;
     private String drivingLicenseImg;


    @OneToMany(mappedBy = "customer")
    private List<Booking> booking=new ArrayList<>();

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }
}
