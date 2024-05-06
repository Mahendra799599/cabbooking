package com.abc.driverservice.service;
import java.util.List;
import com.abc.driverservice.entity.Driver;

public interface DriverService {

    List<Driver> getAllDrivers();

    Driver getDriverById(int id);

    Driver addDriver(Driver driver);

    Driver updateDriver(int id, Driver driver);

    void deleteDriver(int id);
}