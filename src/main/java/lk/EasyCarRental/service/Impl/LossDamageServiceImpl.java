package lk.EasyCarRental.service.Impl;

import lk.EasyCarRental.dto.LossDamageDTO;
import lk.EasyCarRental.entity.LossDamage;
import lk.EasyCarRental.repository.LossDamageRepository;
import lk.EasyCarRental.service.LossDamageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LossDamageServiceImpl implements LossDamageService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    LossDamageRepository lossDamageRepository;

    @Override
    public void saveLostDamage(LossDamageDTO lossDamageDTO) {
        if (!lossDamageRepository.existsById(lossDamageDTO.getLosDamageId())) {
            LossDamage lossDamage = modelMapper.map(lossDamageDTO, LossDamage.class);
            lossDamageRepository.save(lossDamage);
        } else {
            throw new RuntimeException("loss Damage is all ready exist by id " + lossDamageDTO.getLosDamageId());
        }
    }

    @Override
    public void updateLostDamage(LossDamageDTO lossDamageDTO) {
        if (lossDamageRepository.existsById(lossDamageDTO.getLosDamageId())) {
            LossDamage lossDamage = modelMapper.map(lossDamageDTO, LossDamage.class);
            lossDamageRepository.save(lossDamage);
        } else {
            throw new RuntimeException("loss Damage is all ready exist by id " + lossDamageDTO.getLosDamageId());
        }
    }

    @Override
    public void deleteLostDamage(String lossDamageId) {
        if (lossDamageRepository.existsById(lossDamageId)) {
            lossDamageRepository.deleteById(lossDamageId);
        } else {
            throw new RuntimeException("lossDamage is not exist by id " + lossDamageId);
        }
    }

    @Override
    public LossDamageDTO searchLostDamageById(String lossDamageId) {
        Optional<LossDamage> lossDamage =lossDamageRepository.findById(lossDamageId);
        if (lossDamage.isPresent()) {
            return modelMapper.map(lossDamage.get(), LossDamageDTO.class);
        } else {
            throw new RuntimeException("Can not find Loss Damage for this id ");
        }
    }

    @Override
    public List<LossDamageDTO> getAllLostDamage() {
        List<LossDamage> allLossDamage = lossDamageRepository.findAll();
        return modelMapper.map(allLossDamage, new TypeToken<List<LossDamageDTO>>() {
        }.getType());
    }
}
