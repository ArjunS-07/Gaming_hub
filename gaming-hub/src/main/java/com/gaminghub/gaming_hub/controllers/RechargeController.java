package com.gaminghub.gaming_hub.controllers;

import com.gaminghub.gaming_hub.dto.*;
import com.gaminghub.gaming_hub.services.RechargeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/api/recharges")
public class RechargeController {

    private final RechargeService service;
    private static final Logger logger = LoggerFactory.getLogger(RechargeController.class);

    public RechargeController(RechargeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RechargeResponseDTO>> getAllRecharges() {
        return ResponseEntity.ok(service.getAllRecharges());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RechargeResponseDTO> getRechargeById(@PathVariable String id) {
        return ResponseEntity.ok(service.getRechargeById(id));
    }

    @PostMapping
    public ResponseEntity<RechargeResponseDTO> createRecharge(@RequestBody RechargeRequestDTO request) {
        return ResponseEntity.ok(service.createRecharge(request));
    }
}
