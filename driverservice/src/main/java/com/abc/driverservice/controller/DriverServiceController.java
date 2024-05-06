package com.abc.driverservice.controller;
import com.abc.driverservice.entity.Driver;
import com.abc.driverservice.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverServiceController {

 @Autowired
 private DriverService driverService;

 @GetMapping("/all")
 public ResponseEntity<List<Driver>> getAllDrivers() {
     List<Driver> drivers = driverService.getAllDrivers();
     return ResponseEntity.ok(drivers);
 }

 @GetMapping("/{id}")
 public ResponseEntity<Driver> getDriverById(@PathVariable int id) {
     Driver driver = driverService.getDriverById(id);
     if (driver != null) {
         return ResponseEntity.ok(driver);
     } else {
         return ResponseEntity.notFound().build();
     }
 }

 @PostMapping("/add")
 public ResponseEntity<Driver> addDriver(@RequestBody Driver driver) {
     Driver addedDriver = driverService.addDriver(driver);
     return ResponseEntity.status(HttpStatus.CREATED).body(addedDriver);
 }

 @PutMapping("/update/{id}")
 public ResponseEntity<Driver> updateDriver(@PathVariable int id, @RequestBody Driver driver) {
     Driver updatedDriver = driverService.updateDriver(id, driver);
     if (updatedDriver != null) {
         return ResponseEntity.ok(updatedDriver);
     } else {
         return ResponseEntity.notFound().build();
     }
 }

 @DeleteMapping("/delete/{id}")
 public ResponseEntity<Void> deleteDriver(@PathVariable int id) {
     driverService.deleteDriver(id);
     return ResponseEntity.noContent().build();
 }
}
