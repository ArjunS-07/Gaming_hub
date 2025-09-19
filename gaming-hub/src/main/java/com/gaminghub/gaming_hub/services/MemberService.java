package com.gaminghub.gaming_hub.services;

import com.gaminghub.gaming_hub.dto.*;
import com.gaminghub.gaming_hub.mapper.DtoMapper;
import com.gaminghub.gaming_hub.models.Member;
import com.gaminghub.gaming_hub.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public List<MemberResponseDTO> getAllMembers() {
        return repository.findAll()
                .stream()
                .map(DtoMapper::toMemberResponse)
                .collect(Collectors.toList());
    }

    public MemberResponseDTO getMemberById(String id) {
        Member member = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        return DtoMapper.toMemberResponse(member);
    }

    public MemberResponseDTO createMember(MemberRequestDTO request) {
        Member member = DtoMapper.toMember(request);
        Member saved = repository.save(member);
        return DtoMapper.toMemberResponse(saved);
    }

    public void deleteMember(String id) {
        repository.deleteById(id);
    }
}
