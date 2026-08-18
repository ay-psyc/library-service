package com.yuki.libraryservice.service;

import com.yuki.libraryservice.dto.request.CreateMemberRequest;
import com.yuki.libraryservice.dto.request.UpdateBookRequest;
import com.yuki.libraryservice.dto.request.UpdateMemberRequest;
import com.yuki.libraryservice.dto.response.MemberResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface MemberService {
    MemberResponse createMember(CreateMemberRequest request);

    MemberResponse getMemberById(Long id);

    List<MemberResponse> getAllMembers();

    MemberResponse updateMember(Long id, UpdateMemberRequest request);
}
