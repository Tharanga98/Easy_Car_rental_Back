package lk.EasyCarRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LossDamage {

    @Id
    private String losDamageId;
    private String lostDamageImg;
    private Double lostDamageAmount;
    private String description;
}
