package com.triple.backend.child.repository;

import com.triple.backend.child.entity.Child;
import com.triple.backend.child.entity.MbtiHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface MbtiHistoryRepository extends JpaRepository<MbtiHistory, Long> {
  
    MbtiHistory findTopByChild_ChildIdOrderByCreatedAtDesc(Long childId);

    // 삭제될 히스토리 찾는 코드
    List<MbtiHistory> findByReasonAndIsDeleted(String reason, boolean isDeleted);

}
