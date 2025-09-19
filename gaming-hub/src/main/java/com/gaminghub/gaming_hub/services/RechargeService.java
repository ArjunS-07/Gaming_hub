package com.gaminghub.gaming_hub.services;

import com.gaminghub.gaming_hub.dto.*;
import com.gaminghub.gaming_hub.mapper.DtoMapper;
import com.gaminghub.gaming_hub.models.Recharge;
import com.gaminghub.gaming_hub.repository.RechargeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RechargeService {

    private final RechargeRepository repository;

    public RechargeService(RechargeRepository repository) {
        this.repository = repository;
    }

    public List<RechargeResponseDTO> getAllRecharges() {
        return repository.findAll()
                .stream()
                .map(DtoMapper::toRechargeResponse)
                .collect(Collectors.toList());
    }

    public RechargeResponseDTO getRechargeById(String id) {
        Recharge recharge = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recharge not found"));
        return DtoMapper.toRechargeResponse(recharge);
    }

    public RechargeResponseDTO createRecharge(RechargeRequestDTO request) {
        Recharge saved = repository.save(DtoMapper.toRecharge(request));
        return DtoMapper.toRechargeResponse(saved);
    }
}
