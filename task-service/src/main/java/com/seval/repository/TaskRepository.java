package com.seval.repository;

import com.seval.modal.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

 List<Task> findByAssignedUserId(Long userId);

}
