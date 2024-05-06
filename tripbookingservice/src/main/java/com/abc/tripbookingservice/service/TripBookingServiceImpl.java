package com.abc.tripbookingservice.service;
import com.abc.tripbookingservice.entity.TripBooking;
import com.abc.tripbookingservice.repository.TripBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripBookingServiceImpl implements TripBookingService {

 @Autowired
 private TripBookingRepository tripBookingRepository;

 @Override
 public List<TripBooking> getAllTripBookings() {
     return tripBookingRepository.findAll();
 }

 @Override
 public TripBooking getTripBookingById(int id) {
     Optional<TripBooking> optionalTripBooking = tripBookingRepository.findById(id);
     return optionalTripBooking.orElse(null);
 }

 @Override
 public TripBooking addTripBooking(TripBooking tripBooking) {
     return tripBookingRepository.save(tripBooking);
 }

 @Override
 public TripBooking updateTripBooking(int id, TripBooking tripBooking) {
   //  Optional<TripBooking> optionalTripBooking = tripBookingRepository.findById(id);
	 // if (optionalTripBooking.isPresent()) {
	 //  TripBooking existingTripBooking = optionalTripBooking.get();
	 //   existingTripBooking.setDriverId(tripBooking.getDriverId());
	 // existingTripBooking.setCustomerId(tripBooking.getCustomerId());
	 // existingTripBooking.setFromLocation(tripBooking.getFromLocation());
	 // existingTripBooking.setToLocation(tripBooking.getToLocation());
	 //  existingTripBooking.setFromDate(tripBooking.getFromDate());
	 //  existingTripBooking.setToDate(tripBooking.getToDate());
	 //  existingTripBooking.setStatus(tripBooking.isStatus());
	 //  existingTripBooking.setDistanceInKm(tripBooking.getDistanceInKm());
	 //  existingTripBooking.setBill(tripBooking.getBill());
         return tripBookingRepository.save(tripBooking);
     
 }

 @Override
 public void deleteTripBooking(int id) {
     tripBookingRepository.deleteById(id);
 }
}