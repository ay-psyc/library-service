package com.yuki.libraryservice.service.impl;

import com.yuki.libraryservice.dto.request.CreateMemberRequest;
import com.yuki.libraryservice.dto.response.MemberResponse;
import com.yuki.libraryservice.entity.Member;
import com.yuki.libraryservice.exception.MemberAlreadyExistsException;
import com.yuki.libraryservice.mapper.MemberMapper;
import com.yuki.libraryservice.repository.MemberRepository;
import com.yuki.libraryservice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
