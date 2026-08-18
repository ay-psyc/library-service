package com.yuki.libraryservice.controller;

import com.yuki.libraryservice.dto.request.CreateMemberRequest;
import com.yuki.libraryservice.dto.request.UpdateBookRequest;
import com.yuki.libraryservice.dto.request.UpdateMemberRequest;
import com.yuki.libraryservice.dto.response.MemberResponse;
import com.yuki.libraryservice.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponse> createMember(@Valid @RequestBody CreateMemberRequest request) {
        MemberResponse member = memberService.createMember(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(member);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getMemberById(@PathVariable Long id) {
        MemberResponse memberById = memberService.getMemberById(id);
        return ResponseEntity.ok(memberById);
    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getAllMembers() {
        List<MemberResponse> allMembers = memberService.getAllMembers();
        return ResponseEntity.ok(allMembers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberResponse> updateMember(@PathVariable Long id, @Valid @RequestBody UpdateMemberRequest request) {
        MemberResponse memberResponse = memberService.updateMember(id, request);
        return ResponseEntity.ok(memberResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}
