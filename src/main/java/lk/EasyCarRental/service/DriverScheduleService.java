package lk.EasyCarRental.service;


import lk.EasyCarRental.dto.DriverScheduleDTO;

import java.util.List;

public interface DriverScheduleService {

    void saveDriverSchedule(DriverScheduleDTO driverScheduleDTO);

    void updateDriverSchedule(DriverScheduleDTO driverScheduleDTO);

    void deleteDriverSchedule(String scheduleId);

    DriverScheduleDTO searchDriverScheduleById(String scheduleId);

    List<DriverScheduleDTO> getAllDriversSchedule();
}
