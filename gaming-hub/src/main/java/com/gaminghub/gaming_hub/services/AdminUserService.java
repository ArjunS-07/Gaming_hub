package com.gaminghub.gaming_hub.services;

import com.gaminghub.gaming_hub.models.AdminUser;
import com.gaminghub.gaming_hub.repository.AdminUserRepository;
import com.gaminghub.gaming_hub.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserService {

    private final AdminUserRepository repository;

    public AdminUserService(AdminUserRepository repository) {
        this.repository = repository;
    }

    public List<AdminUser> getAllAdmins() {
        return repository.findAll();
    }

    public AdminUser getAdminById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with id: " + id));
    }

    public AdminUser createAdmin(AdminUser adminUser) {
        return repository.save(adminUser);
    }

    public AdminUser getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with username: " + username));
    }

    public void deleteAdmin(String id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Admin not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
