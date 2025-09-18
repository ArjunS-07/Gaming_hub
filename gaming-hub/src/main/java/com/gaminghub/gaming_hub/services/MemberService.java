package com.gaminghub.gaming_hub.services;

import com.gaminghub.gaming_hub.models.*;
import com.gaminghub.gaming_hub.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(String id) {
        return memberRepository.findById(id);
    }

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(String id, Member updatedMember) {
        return memberRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedMember.getName());
                    existing.setPhone(updatedMember.getPhone());
                    existing.setBalance(updatedMember.getBalance());
                    return memberRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
    }

    public void deleteMember(String id) {
        memberRepository.deleteById(id);
    }
}
