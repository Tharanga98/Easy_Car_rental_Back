package lk.EasyCarRental.service;

import lk.EasyCarRental.dto.LossDamageDTO;

import java.util.List;

public interface LossDamageService {

    void saveLostDamage(LossDamageDTO lossDamageDTO);

    void updateLostDamage(LossDamageDTO lossDamageDTO);

    void deleteLostDamage(String lossDamageDAO);

    LossDamageDTO searchLostDamageById(String lossDamageDAO);

    List<LossDamageDTO> getAllLostDamage();
}
