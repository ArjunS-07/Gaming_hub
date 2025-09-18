package com.gaminghub.gaming_hub.controllers;

import com.gaminghub.gaming_hub.models.Recharge;
import com.gaminghub.gaming_hub.services.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/recharges")
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;

    @GetMapping
    public List<Recharge> getAllRecharges() {
        return rechargeService.getAllRecharges();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recharge> getRechargeById(@PathVariable String id) {
        return ResponseEntity.ok(rechargeService.getRechargeById(id));
    }

    @PostMapping
    public Recharge addRecharge(@RequestBody Map<String, Object> payload) {
        String memberId = (String) payload.get("memberId");
        double amount = ((Number) payload.get("amount")).doubleValue();
        return rechargeService.addRecharge(memberId, amount);
    }
}
