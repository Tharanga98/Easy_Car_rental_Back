package lk.EasyCarRental.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DriverDTO {
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


    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getNicNumber() {
        return nicNumber;
    }

    public void setNicNumber(String nicNumber) {
        this.nicNumber = nicNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getNicImg() {
        return nicImg;
    }

    public void setNicImg(String nicImg) {
        this.nicImg = nicImg;
    }

    public String getDriverImg() {
        return driverImg;
    }

    public void setDriverImg(String driverImg) {
        this.driverImg = driverImg;
    }

    public String getDriverLicenseImg() {
        return driverLicenseImg;
    }

    public void setDriverLicenseImg(String driverLicenseImg) {
        this.driverLicenseImg = driverLicenseImg;
    }

    public boolean isAvailableState() {
        return availableState;
    }

    public void setAvailableState(boolean availableState) {
        this.availableState = availableState;
    }
}
