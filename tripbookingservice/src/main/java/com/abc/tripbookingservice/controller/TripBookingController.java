package com.abc.tripbookingservice.controller;
import com.abc.tripbookingservice.entity.TripBooking;
import com.abc.tripbookingservice.service.TripBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/tripbooking")
public class TripBookingController {

 @Autowired
 private TripBookingService tripBookingService;

 @GetMapping("/all")
 public ResponseEntity<List<TripBooking>> getAllTripBookings() {
     List<TripBooking> tripBookings = tripBookingService.getAllTripBookings();
     return ResponseEntity.ok(tripBookings);
 }

 @GetMapping("/booking/{id}")
 public ResponseEntity<TripBooking> getTripBookingById(@PathVariable int id) {
     TripBooking tripBooking = tripBookingService.getTripBookingById(id);
     if (tripBooking != null) {
         return ResponseEntity.ok(tripBooking);
     } else {
         return ResponseEntity.notFound().build();
     }
 }
 @PostMapping("/add")
 public ResponseEntity<TripBooking> addTripBooking(@RequestBody TripBooking tripBooking) {
     TripBooking addedTripBooking = tripBookingService.addTripBooking(tripBooking);
     return ResponseEntity.status(HttpStatus.CREATED).body(addedTripBooking);
 }
 @PutMapping("/update/{id}")
 public ResponseEntity<TripBooking> updateTripBooking(@PathVariable int id, @RequestBody TripBooking tripBooking) {
     TripBooking updatedTripBooking = tripBookingService.updateTripBooking(id, tripBooking);
     if (updatedTripBooking != null) {
         return ResponseEntity.ok(updatedTripBooking);
     } else {
         return ResponseEntity.notFound().build();
     }
 }

 @DeleteMapping("/delete/{id}")
 public ResponseEntity<Void> deleteTripBooking(@PathVariable int id) {
     tripBookingService.deleteTripBooking(id);
     return ResponseEntity.noContent().build();
 }
}