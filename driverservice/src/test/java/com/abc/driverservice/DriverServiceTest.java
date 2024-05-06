package com.abc.driverservice;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.driverservice.entity.Driver;
import com.abc.driverservice.exception.ResourceNotFoundException;
import com.abc.driverservice.repository.DriverRepository;
import com.abc.driverservice.service.DriverServiceImpl;

@SpringBootTest(properties = "eureka.client.enabled=false")
public class DriverServiceTest {

    @InjectMocks
    private DriverServiceImpl driverServiceImpl;

    @Mock
    private DriverRepository driverRepository;

    @Test
    public void testGetAllDrivers() {
        Driver driver1 = new Driver();
        driver1.setDriverId(1);
        driver1.setCabId(101);
        driver1.setLicenseNo("ABC123");
        driver1.setRating(4.5f);
        driver1.setAvailableCab("Yes");
        driver1.setTripBooking("No");

        Driver driver2 = new Driver();
        driver2.setDriverId(2);
        driver2.setCabId(102);
        driver2.setLicenseNo("XYZ456");
        driver2.setRating(4.0f);
        driver2.setAvailableCab("No");
        driver2.setTripBooking("Yes");

        List<Driver> drivers = new ArrayList<>();
        drivers.add(driver1);
        drivers.add(driver2);

        when(driverRepository.findAll()).thenReturn(drivers);

        List<Driver> driverList = driverServiceImpl.getAllDrivers();
        assertEquals(2, driverList.size());
    }

    @Test
    public void testAddDriver() {
        Driver driver = new Driver();
        driver.setDriverId(3);
        driver.setCabId(103);
        driver.setLicenseNo("PQR789");
        driver.setRating(4.2f);
        driver.setAvailableCab("Yes");
        driver.setTripBooking("No");

        when(driverRepository.save(driver)).thenReturn(driver);

        Driver savedDriver = driverServiceImpl.addDriver(driver);
        assertNotNull(savedDriver);
        assertEquals(driver, savedDriver);
    }

    @Test
    public void testGetDriverByIdWithException() {
        when(driverRepository.findById(5)).thenThrow(new ResourceNotFoundException("Driver not found with id: 5"));

        assertThrows(ResourceNotFoundException.class, () -> driverServiceImpl.getDriverById(5));
    }

}
