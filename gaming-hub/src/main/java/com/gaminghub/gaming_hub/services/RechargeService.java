package com.gaminghub.gaming_hub.services;

import com.gaminghub.gaming_hub.exception.ResourceNotFoundException;
import com.gaminghub.gaming_hub.models.Member;
import com.gaminghub.gaming_hub.models.Recharge;
import com.gaminghub.gaming_hub.repository.MemberRepository;
import com.gaminghub.gaming_hub.repository.RechargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RechargeService {

    @Autowired
    private RechargeRepository rechargeRepository;

    @Autowired
    private MemberRepository memberRepository;

    public List<Recharge> getAllRecharges() {
        return rechargeRepository.findAll();
    }

    public Recharge getRechargeById(String id) {
        return rechargeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recharge not found with id: " + id));
    }

    public Recharge addRecharge(String memberId, double amount) {
        // Find member
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + memberId));

        // Update balance
        member.setBalance(member.getBalance() + amount);
        memberRepository.save(member);

        // Create recharge record
        Recharge recharge = new Recharge(memberId, amount, LocalDateTime.now());
        return rechargeRepository.save(recharge);
    }
}
