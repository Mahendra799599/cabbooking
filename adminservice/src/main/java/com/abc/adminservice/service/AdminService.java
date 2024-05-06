package com.abc.adminservice.service;
import java.util.List;
import com.abc.adminservice.entity.Admin;
public interface AdminService {
Admin addAdmin(Admin admin);
Admin updateAdmin(int adminId, Admin updatedAdmin);
void deleteAdmin(int adminId);
Admin getAdminById(Long id);
List<Admin> getAllAdmins();
Admin updateAdmin(Long id, Admin admin);
void deleteAdmin(Long id);
Admin getAdminById(int adminId);
}