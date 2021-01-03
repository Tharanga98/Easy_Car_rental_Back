package lk.EasyCarRental.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Booking {

    @Id
    private String bookingId;
    private Date pickUpDateTime;
    private Date returnDateTime;
    private String pickUpLocation;
    private String returnLocation;
    private int vehicleCount;
    private String note;

    //------------ customer & booking (one to many) ==================================


   @SuppressWarnings("JpaDataSourceORMInspection")
   @ManyToOne
   @JoinColumn(name = "customerId",referencedColumnName = "customerId")
   private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
