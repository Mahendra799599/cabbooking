package com.abc.tripbookingservice.service;
import com.abc.tripbookingservice.entity.TripBooking;
import java.util.List;

public interface TripBookingService {

 List<TripBooking> getAllTripBookings();

 TripBooking getTripBookingById(int id);

 TripBooking addTripBooking(TripBooking tripBooking);

 TripBooking updateTripBooking(int id, TripBooking tripBooking);

 void deleteTripBooking(int id);
}
