package com.abc.adminservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.adminservice.entity.Admin;
import com.abc.adminservice.repository.AdminRepository;


import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdmin(Long id, Admin admin) {

            return adminRepository.save(admin);
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

	@Override
	public Admin updateAdmin(int adminId, Admin updatedAdmin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAdmin(int adminId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Admin getAdminById(int adminId) {
		// TODO Auto-generated method stub
		return null;
	}
}
