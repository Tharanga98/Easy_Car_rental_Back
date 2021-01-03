package lk.EasyCarRental.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class LossDamageDTO {

    private String losDamageId;
    private String lostDamageImg;
    private Double lostDamageAmount;
    private String description;

    public String getLosDamageId() {
        return losDamageId;
    }

    public void setLosDamageId(String losDamageId) {
        this.losDamageId = losDamageId;
    }

    public String getLostDamageImg() {
        return lostDamageImg;
    }

    public void setLostDamageImg(String lostDamageImg) {
        this.lostDamageImg = lostDamageImg;
    }

    public Double getLostDamageAmount() {
        return lostDamageAmount;
    }

    public void setLostDamageAmount(Double lostDamageAmount) {
        this.lostDamageAmount = lostDamageAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
