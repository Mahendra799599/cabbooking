package com.abc.cabservice;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.cabservice.entity.Cab;
import com.abc.cabservice.exception.ResourceNotFoundException;
import com.abc.cabservice.repository.CabRepository;
import com.abc.cabservice.service.CabServiceImpl;
@SpringBootTest(properties = "eureka.client.enabled=false")

public class CabServiceTest {

   
    @InjectMocks
private CabServiceImpl cabServiceImpl;
    @Mock
    private CabRepository cabRepository;
    
    

    @Test
    public void testGetAllCabs() {
       Cab cab=new Cab();
       cab.setCabId(1);
       cab.setCartype("Thar");
       cab.setDriver("Rajesh");
       cab.setRatePerKm(200);
       
       
       Cab cab1=new Cab();
       cab1.setCabId(1);
       cab1.setCartype("Thar");
       cab1.setDriver("Rajesh");
       cab1.setRatePerKm(200);
       
       Cab cab2=new Cab();
       cab2.setCabId(1);
       cab2.setCartype("Thar");
       cab2.setDriver("Rajesh");
       cab2.setRatePerKm(200);
       
       
       List<Cab>cabs=new ArrayList<>();
       cabs.add(cab);
       cabs.add(cab1);
       cabs.add(cab2);
       
       
       when(cabRepository.findAll()).thenReturn(cabs);

		List<Cab> cabList = cabServiceImpl.getAllCabs();
		assertEquals(3, cabList.size());
       
		
    }
    
    
    @Test
    public void testAddCab() {
    	Cab cab=new Cab();
    	cab.setCabId(2);
    	cab.setCartype("Thar");
    	cab.setDriver("lala");
    	cab.setRatePerKm(200);
    	
    	
    	
    	Cab cab1=new Cab();
    	cab1.setCabId(2);
    	cab1.setCartype("MAHINDRA");
    	cab1.setDriver("lala");
    	cab1.setRatePerKm(200);
    	
    	
    	Cab cab2=new Cab();
    	cab2.setCabId(2);
    	cab2.setCartype("INNOVA");
    	cab2.setDriver("HEMANT");
    	cab2.setRatePerKm(300);
    	
    	
		when(cabRepository.save(cab)).thenReturn(cab);
		Cab savedCab=cabServiceImpl.addCab(cab);
		verify(cabRepository,times(1)).save(cab);
		assertNotNull(savedCab);
		
		assertEquals(cab.getCabId(),savedCab.getCabId());
		assertEquals(cab.getCartype(),savedCab.getCartype());
		assertEquals(cab.getDriver(),savedCab.getDriver());
		assertEquals(cab.getRatePerKm(),savedCab.getRatePerKm());
    	
    }
    @Test
    public void testGetCabByIdWithException() {
    	Cab cab=new Cab();
    	cab.setCabId(23);
    	cab.setCartype("Thar");
    	cab.setDriver("rajesh");
    	cab.setRatePerKm(200);
    	
    	
		when(cabRepository.findById(23)).thenThrow(new ResourceNotFoundException("Flat is not existing with id:100"));

		assertThrows(ResourceNotFoundException.class, () -> cabServiceImpl.getCabById(23));

		verify(cabRepository, times(0)).getById(23);
    	
    }

}
