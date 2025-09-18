package com.gaminghub.gaming_hub.controllers;

import com.gaminghub.gaming_hub.models.AdminUser;
import com.gaminghub.gaming_hub.services.AdminUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminUserController {

    private final AdminUserService service;

    public AdminUserController(AdminUserService service) {
        this.service = service;
    }

    @GetMapping
    public List<AdminUser> getAllAdmins() {
        return service.getAllAdmins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminUser> getAdminById(@PathVariable String id) {
        return ResponseEntity.ok(service.getAdminById(id));
    }

    @PostMapping
    public ResponseEntity<AdminUser> createAdmin(@RequestBody AdminUser adminUser) {
        return ResponseEntity.ok(service.createAdmin(adminUser));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<AdminUser> getByUsername(@PathVariable String username) {
        return ResponseEntity.ok(service.getByUsername(username));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable String id) {
        service.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
