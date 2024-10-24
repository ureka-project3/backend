package com.triple.backend.test.entity;

import com.triple.backend.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
public class Test extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Long testId;

    @Column(name = "test_name")
    private String name;

    @Column(name = "test_description")
    private String description;
}
