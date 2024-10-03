package com.seval.task_submission_service.modal;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.List;

public class TaskDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private String image;

    private Long assignedUserId;

    private List<String> tags;

    private TaskStatus status;

    private LocalDateTime deadLine;
    private LocalDateTime createdAt;
}
