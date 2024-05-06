package com.abc.driverservice.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.driverservice.entity.Driver;
import com.abc.driverservice.repository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Driver getDriverById(int id) {
        Optional<Driver> optionalDriver = driverRepository.findById(id);
        return optionalDriver.orElse(null);
    }

    @Override
    public Driver addDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Driver updateDriver(int id, Driver driver) {
      //  Optional<Driver> optionalDriver = driverRepository.findById(id);
        //if (optionalDriver.isPresent()) {
          //  Driver existingDriver = optionalDriver.get();
            //existingDriver.setCabId(driver.getCabId());
           // existingDriver.setLicenseNo(driver.getLicenseNo());
         //   existingDriver.setRating(driver.getRating());
           // existingDriver.setAvailableCab(driver.getAvailableCab());
           // existingDriver.setTripBooking(driver.getTripBooking());
            return driverRepository.save(driver);
    }

    @Override
    public void deleteDriver(int id) {
        driverRepository.deleteById(id);
    }
}