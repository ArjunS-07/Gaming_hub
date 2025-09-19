package com.gaminghub.gaming_hub.controllers;

import com.gaminghub.gaming_hub.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.gaminghub.gaming_hub.services.AdminUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminUserController {

    private final AdminUserService service;
    private static final Logger logger = LoggerFactory.getLogger(AdminUserController.class);

    public AdminUserController(AdminUserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AdminUserResponseDTO>> getAllAdmins() {
        return ResponseEntity.ok(service.getAllAdmins());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminUserResponseDTO> getAdminById(@PathVariable String id) {
        return ResponseEntity.ok(service.getAdminById(id));
    }

    @PostMapping
    public ResponseEntity<AdminUserResponseDTO> createAdmin(@RequestBody AdminUserRequestDTO request) {
        return ResponseEntity.ok(service.createAdmin(request));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<AdminUserResponseDTO> getByUsername(@PathVariable String username) {
        return ResponseEntity.ok(service.getByUsername(username));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable String id) {
        service.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
