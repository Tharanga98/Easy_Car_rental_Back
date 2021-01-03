package lk.EasyCarRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Payment {

    @Id
    private String paymentId;
    private double amount;
    private String paymentMethod;
    private Date paymentDateTime;


}
