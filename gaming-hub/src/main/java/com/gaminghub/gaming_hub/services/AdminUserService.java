package com.gaminghub.gaming_hub.services;

import com.gaminghub.gaming_hub.dto.*;
import com.gaminghub.gaming_hub.mapper.DtoMapper;
import com.gaminghub.gaming_hub.models.AdminUser;
import com.gaminghub.gaming_hub.repository.AdminUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminUserService {

    private final AdminUserRepository repository;

    public AdminUserService(AdminUserRepository repository) {
        this.repository = repository;
    }

    public List<AdminUserResponseDTO> getAllAdmins() {
        return repository.findAll()
                .stream()
                .map(DtoMapper::toAdminUserResponse)
                .collect(Collectors.toList());
    }

    public AdminUserResponseDTO getAdminById(String id) {
        AdminUser admin = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        return DtoMapper.toAdminUserResponse(admin);
    }

    public AdminUserResponseDTO createAdmin(AdminUserRequestDTO request) {
        AdminUser saved = repository.save(DtoMapper.toAdminUser(request));
        return DtoMapper.toAdminUserResponse(saved);
    }

    public AdminUserResponseDTO getByUsername(String username) {
        AdminUser admin = repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
        return DtoMapper.toAdminUserResponse(admin);
    }

    public void deleteAdmin(String id) {
        repository.deleteById(id);
    }
}
