package com.triple.backend.auth.dto;

import com.triple.backend.member.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

// 사용자 인증 및 권한 부여
public class CustomMemberDetails implements UserDetails {
    private final Member member;

    public CustomMemberDetails(Member member) {
        this.member = member;

    }

    // 사용자의 role 값을 반환 (우리는 공통코드 작업이라 사용 X)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {

                return "success"; //  return userEntity.getRole(); 이 정상
            }
        });

        return collection;
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