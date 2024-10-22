package com.triple.backend.auth.dto;

import com.triple.backend.member.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

// 사용자 인증 및 권한 부여
public class CustomMemberDetails implements UserDetails {
    private final Member member;

    public CustomMemberDetails(Member member) {
        this.member = member;

    }

    // 사용자의 role 값을 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        // role이 null인 경우 방어 코드 추가
        if (member.getRole() != null) {
            String roleCodeId = member.getRole().getId().getCodeId();
            authorities.add(new SimpleGrantedAuthority("ROLE_" + roleCodeId));

            // 역할 이름 추가
            authorities.add(new SimpleGrantedAuthority(member.getRole().getCommonName()));
        }

        return authorities;
    }


    // password 값을 반환
    @Override
    public String getPassword() {
        return member.getPassword();
    }

    // 사용자 이름 반환
    @Override
    public String getUsername() {
        return member.getEmail();
    }

    // Member 엔티티에서 getMemberId를 반환
    public Long getMemberId() {
        return member.getMemberId();
    }

    // 계정 만료 여부
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠겨 있는지 여부
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 비밀번호 만료 여부
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정이 활성화 여부
    @Override
    public boolean isEnabled() {
        return true;
    }
}