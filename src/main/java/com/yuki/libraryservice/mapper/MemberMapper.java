package com.yuki.libraryservice.mapper;

import com.yuki.libraryservice.dto.request.CreateMemberRequest;
import com.yuki.libraryservice.dto.response.MemberResponse;
import com.yuki.libraryservice.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public MemberResponse toResponse(Member member) {
        return new MemberResponse(
                member.getId(),
                member.getName(),
                member.getEmail()
        );
    }

    public Member toEntity(CreateMemberRequest request) {
        Member member = new Member();
        member.setName(request.getName());
        member.setEmail(request.getEmail());
        return member;
    }

}
