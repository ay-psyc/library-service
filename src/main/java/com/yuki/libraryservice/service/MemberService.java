package com.yuki.libraryservice.service;

import com.yuki.libraryservice.dto.request.CreateMemberRequest;
import com.yuki.libraryservice.dto.response.MemberResponse;

public interface MemberService {
    MemberResponse createMember(CreateMemberRequest request);
}
