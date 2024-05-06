package com.abc.tripbookingservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.tripbookingservice.entity.TripBooking;
import com.abc.tripbookingservice.exception.ResourceNotFoundException;
import com.abc.tripbookingservice.repository.TripBookingRepository;
import com.abc.tripbookingservice.service.TripBookingServiceImpl;

@SpringBootTest(properties = "eureka.client.enabled=false")
public class TripBookingTest {
    @InjectMocks
    private TripBookingServiceImpl tripBookingServiceImpl;
    @Mock
    private TripBookingRepository tripBookingRepository;
    @Test
    public void testGetAllTripBookings() {
        TripBooking tripBooking1 = new TripBooking();
        tripBooking1.setBookingId(1);
        tripBooking1.setDriverId(101);
        tripBooking1.setCustomerId(201);
        tripBooking1.setFromLocation("Location A");
        tripBooking1.setToLocation("Location B");
        tripBooking1.setFromDate(LocalDateTime.of(2024, 5, 5, 10, 0));
        tripBooking1.setToDate(LocalDateTime.of(2024, 5, 5, 12, 0));
        tripBooking1.setStatus(true);
        tripBooking1.setDistanceInKm(10.5f);
        tripBooking1.setBill(250.0f);

        TripBooking tripBooking2 = new TripBooking();
        tripBooking2.setBookingId(2);
        tripBooking2.setDriverId(102);
        tripBooking2.setCustomerId(202);
        tripBooking2.setFromLocation("Location C");
        tripBooking2.setToLocation("Location D");
        tripBooking2.setFromDate(LocalDateTime.of(2024, 5, 6, 11, 0));
        tripBooking2.setToDate(LocalDateTime.of(2024, 5, 6, 13, 0));
        tripBooking2.setStatus(false);
        tripBooking2.setDistanceInKm(15.0f);
        tripBooking2.setBill(300.0f);

        List<TripBooking> tripBookings = new ArrayList<>();
        tripBookings.add(tripBooking1);
        tripBookings.add(tripBooking2);

        when(tripBookingRepository.findAll()).thenReturn(tripBookings);

        List<TripBooking> tripBookingList = tripBookingServiceImpl.getAllTripBookings();
        assertEquals(2, tripBookingList.size());
    }

   
    @Test
    public void testAddTripBooking() {
        TripBooking tripBooking = new TripBooking();
        tripBooking.setBookingId(1);
        tripBooking.setDriverId(101);
        tripBooking.setCustomerId(201);
        tripBooking.setFromLocation("Location A");
        tripBooking.setToLocation("Location B");
        tripBooking.setFromDate(LocalDateTime.of(2024, 5, 5, 10, 0));
        tripBooking.setToDate(LocalDateTime.of(2024, 5, 5, 12, 0));
        tripBooking.setStatus(true);
        tripBooking.setDistanceInKm(10.5f);
        tripBooking.setBill(250.0f);

        when(tripBookingRepository.save(tripBooking)).thenReturn(tripBooking);

        TripBooking savedTripBooking = tripBookingServiceImpl.addTripBooking(tripBooking);
        assertNotNull(savedTripBooking);
        assertEquals(tripBooking, savedTripBooking);
    }

    @Test
    public void testDeleteTripBooking() {
        doNothing().when(tripBookingRepository).deleteById(1);
        tripBookingServiceImpl.deleteTripBooking(1);
        verify(tripBookingRepository, times(1)).deleteById(1);
    }

    @Test
    public void testGetAllTripBookings_EmptyList() {
       when(tripBookingRepository.findAll()).thenReturn(new ArrayList<>());

       List<TripBooking> tripBookingList = tripBookingServiceImpl.getAllTripBookings();
       assertEquals(0, tripBookingList.size());
    }

    

   

    @Test
    public void testDeleteTripBooking_NotFound() {
        doThrow(ResourceNotFoundException.class).when(tripBookingRepository).deleteById(1);

        assertThrows(ResourceNotFoundException.class, () -> tripBookingServiceImpl.deleteTripBooking(1));
    }
}

