package com.triple.backend.test.service;

import com.triple.backend.test.dto.TestAnswerRequestDto;
import com.triple.backend.test.dto.TestParticipationRequestDto;
import com.triple.backend.test.dto.TestQuestionResponseDto;
import com.triple.backend.test.dto.TestResultResponseDto;
import org.springframework.data.domain.Pageable;


public interface TestService {
    // 자녀 성향 질문 조회
    TestQuestionResponseDto getTestQuestion(Long testId, Pageable pageable);

    // 자녀 성향 진단 결과 조회
    TestResultResponseDto getTestResult(Long childId);

    // 자녀 성향 진단 결과 등록
    void insertTestResult(Long testId, TestAnswerRequestDto testAnswerRequestDto, Long childId);

    // 자녀 성향 진단 참여 등록
    void insertTestParticipation(TestParticipationRequestDto dto);

}
