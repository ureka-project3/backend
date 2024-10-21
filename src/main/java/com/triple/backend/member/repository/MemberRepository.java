package com.triple.backend.member.repository;

import com.triple.backend.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    // memberId로 멤버를 찾는 메서드
    Optional<Member> findByMemberId(Long memberId);

    // 소셜 로그인에서 제공한 providerId로 멤버를 찾는 메서드
    Optional<Member> findByProviderId(String providerId);

    // 해당 유저 조회
    Member findByEmail(String email);

    // email이 이미 존재하는지 확인(중복체크)
    Boolean existsByEmail(String email);

}