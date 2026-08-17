package com.yuki.libraryservice.service;

import com.yuki.libraryservice.dto.request.CreateMemberRequest;
import com.yuki.libraryservice.dto.response.MemberResponse;

import java.util.List;

public interface MemberService {
    MemberResponse createMember(CreateMemberRequest request);

    MemberResponse getMemberById(Long id);

    List<MemberResponse> getAllMembers();
}
