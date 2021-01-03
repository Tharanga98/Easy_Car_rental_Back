package lk.EasyCarRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Driver {
    @Id
    private String driverId;
    private String driverName;
    private String email;
    private String password;
    private String address;
    private String contactNumber;
    private String nicNumber;
    private String licenseNumber;
    private String nicImg;
    private String driverImg;
    private String driverLicenseImg;
    private boolean availableState;


    @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL)
    private DriverSchedule driverSchedule;

    public DriverSchedule getDriverSchedule() {
        return driverSchedule;
    }

    public void setDriverSchedule(DriverSchedule driverSchedule) {
        this.driverSchedule = driverSchedule;
    }


}
