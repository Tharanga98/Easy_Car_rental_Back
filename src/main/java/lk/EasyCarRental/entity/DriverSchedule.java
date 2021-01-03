package lk.EasyCarRental.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;


@SuppressWarnings("JpaObjectClassSignatureInspection")
@Entity
@NoArgsConstructor
@Data
public class DriverSchedule {

    @Id
    private String scheduleId;
    private Date startDate;
    private Date endDate;

    @SuppressWarnings({"unused", "JpaDataSourceORMInspection"})
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driverId" ,referencedColumnName = "driverId")
    private Driver driver;

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }


    public DriverSchedule(String scheduleId, Date startDate, Date endDate, Driver driver) {
        this.scheduleId = scheduleId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.driver = driver;
    }
}
