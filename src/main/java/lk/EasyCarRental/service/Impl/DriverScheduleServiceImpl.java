package lk.EasyCarRental.service.Impl;


import lk.EasyCarRental.dto.DriverScheduleDTO;
import lk.EasyCarRental.entity.DriverSchedule;
import lk.EasyCarRental.repository.DriverScheduleRepository;
import lk.EasyCarRental.service.DriverScheduleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DriverScheduleServiceImpl implements DriverScheduleService {

    @Autowired
    DriverScheduleRepository scheduleRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveDriverSchedule(DriverScheduleDTO driverScheduleDTO) {
        if(!scheduleRepository.existsById(driverScheduleDTO.getScheduleId())){
            DriverSchedule driverSchedule=modelMapper.map(driverScheduleDTO, DriverSchedule.class);
            scheduleRepository.save(driverSchedule);
        }else{
            throw new RuntimeException("Driver is all ready exist by id "+driverScheduleDTO.getScheduleId());
        }
    }

    @Override
    public void updateDriverSchedule(DriverScheduleDTO driverScheduleDTO) {
        if(scheduleRepository.existsById(driverScheduleDTO.getScheduleId())){
            DriverSchedule driverSchedule=modelMapper.map(driverScheduleDTO, DriverSchedule.class);
            scheduleRepository.save(driverSchedule);
        }else{
            throw new RuntimeException("Driver is all ready exist by id "+driverScheduleDTO.getScheduleId());
        }
    }

    @Override
    public void deleteDriverSchedule(String scheduleId) {
        if(scheduleRepository.existsById(scheduleId)){
            scheduleRepository.deleteById(scheduleId);
        }else{
            throw new RuntimeException("DriverSchedule is not exist by id "+scheduleId);
        }
    }

    @Override
    public DriverScheduleDTO searchDriverScheduleById(String scheduleId) {
        Optional<DriverSchedule> driverSchedule= scheduleRepository.findById(scheduleId);
        if(driverSchedule.isPresent()){
            return  modelMapper.map(driverSchedule.get(), DriverScheduleDTO.class);
        }else{
            throw new RuntimeException("Can not find DriverSchedule for this id "+scheduleId);
        }
    }

    @Override
    public List<DriverScheduleDTO> getAllDriversSchedule() {
        List<DriverSchedule> driverSchedules=scheduleRepository.findAll();
        return  modelMapper.map(driverSchedules,new TypeToken<List<DriverScheduleDTO>>(){}.getType());
    }
}
