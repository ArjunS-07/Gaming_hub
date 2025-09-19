package com.gaminghub.gaming_hub.controllers;

import com.gaminghub.gaming_hub.dto.*;
import com.gaminghub.gaming_hub.services.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService service;
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MemberResponseDTO>> getAllMembers() {
        return ResponseEntity.ok(service.getAllMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDTO> getMemberById(@PathVariable String id) {
        return ResponseEntity.ok(service.getMemberById(id));
    }

    @PostMapping
    public ResponseEntity<MemberResponseDTO> createMember(@RequestBody MemberRequestDTO request) {
    	logger.info("Received request to create member: {}", request.getName());
        return ResponseEntity.ok(service.createMember(request));
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable String id) {
        service.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}
