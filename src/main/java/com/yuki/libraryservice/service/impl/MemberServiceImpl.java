package com.yuki.libraryservice.service.impl;

import com.yuki.libraryservice.dto.request.CreateMemberRequest;
import com.yuki.libraryservice.dto.request.UpdateBookRequest;
import com.yuki.libraryservice.dto.request.UpdateMemberRequest;
import com.yuki.libraryservice.dto.response.MemberResponse;
import com.yuki.libraryservice.entity.Member;
import com.yuki.libraryservice.exception.MemberAlreadyExistsException;
import com.yuki.libraryservice.exception.MemberNotFoundException;
import com.yuki.libraryservice.mapper.MemberMapper;
import com.yuki.libraryservice.repository.MemberRepository;
import com.yuki.libraryservice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    public MemberResponse createMember(CreateMemberRequest request) {
        if (memberRepository.existsByEmail(request.getEmail())) {
            throw new MemberAlreadyExistsException("Member already exists");
        }

        Member entity = memberMapper.toEntity(request);
        Member saved = memberRepository.save(entity);
        return memberMapper.toResponse(saved);
    }

    @Override
    public MemberResponse getMemberById(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException("Member not found"));
        return memberMapper.toResponse(member);
    }

    @Override
    public List<MemberResponse> getAllMembers() {
        List<Member> memberList = memberRepository.findAll();
        return memberList.stream().map(member -> memberMapper.toResponse(member)).toList();
    }

    @Override
    public MemberResponse updateMember(Long id, UpdateMemberRequest request) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException("Member not found"));
        member.setName(request.getName());
        member.setEmail(request.getEmail());
        Member saved = memberRepository.save(member);
        return memberMapper.toResponse(saved);
    }

    @Override
    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException("Member not found"));
        memberRepository.delete(member);
    }

}
