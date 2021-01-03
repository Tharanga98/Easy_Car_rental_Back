package lk.EasyCarRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {

    @Id
    private String carId;
    private String type;
    private String brandName;
    private String noOfPassenger;
    private String fuelType;
    private double dailyRate;
    private double monthlyRate;
    private double freeKmMonth;
    private double pricePerExtraKm;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "categoryId" , referencedColumnName = "categoryId")
    private CarCategory carCategory;

    public CarCategory getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(CarCategory carCategory) {
        this.carCategory = carCategory;
    }
}
