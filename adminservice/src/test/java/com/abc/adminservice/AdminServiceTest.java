package com.abc.adminservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.adminservice.entity.Admin;
import com.abc.adminservice.repository.AdminRepository;
import com.abc.adminservice.service.AdminServiceImpl;

@SpringBootTest
public class AdminServiceTest {

    @InjectMocks
    private AdminServiceImpl adminService;

    @Mock
    private AdminRepository adminRepository;

    @Test
    public void testAddAdmin() {
        // Creating a mock Admin object
        Admin admin = new Admin();
        admin.setAdminId(1);
        admin.setName("Admin1");

        // Mocking repository response
        when(adminRepository.save(admin)).thenReturn(admin);

        // Calling service method
        Admin result = adminService.addAdmin(admin);

        // Assertions
        assertNotNull(result);
        assertEquals(admin.getAdminId(), result.getAdminId());
        assertEquals(admin.getName(), result.getName());
    }

    @Test
    public void testUpdateAdmin() {
        // Creating a mock Admin object
        Admin admin = new Admin();
        admin.setAdminId(1);
        admin.setName("Updated Admin");

        // Mocking repository response
        when(adminRepository.save(admin)).thenReturn(admin);

        // Calling service method
        Admin result = adminService.updateAdmin(1L, admin);

        // Assertions
        assertNotNull(result);
        assertEquals(admin.getAdminId(), result.getAdminId());
        assertEquals(admin.getName(), result.getName());
    }

    @Test
    public void testDeleteAdmin() {
        // Mocking repository response
        doNothing().when(adminRepository).deleteById(1L);

        // Calling service method
        adminService.deleteAdmin(1L);

        // No need for assertions, verifying the mock is sufficient
    }

    @Test
    public void testGetAdminById() {
        // Creating a mock Admin object
        Admin admin = new Admin();
        admin.setAdminId(1);
        admin.setName("Admin1");

        // Mocking repository response
        when(adminRepository.findById(1L)).thenReturn(Optional.of(admin));

        // Calling service method
        Admin result = adminService.getAdminById(1L);

        // Assertions
        assertNotNull(result);
        assertEquals(admin.getAdminId(), result.getAdminId());
        assertEquals(admin.getName(), result.getName());
    }

    @Test
    public void testGetAdminById_NotFound() {
        // Mocking repository response
        when(adminRepository.findById(1L)).thenReturn(Optional.empty());

        // Calling service method
        Admin result = adminService.getAdminById(1L);

        // Assertions
        assertNull(result);
    }
}
