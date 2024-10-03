package com.seval.task_submission_service.service;

import com.seval.task_submission_service.modal.Submission;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubmissionService {

    Submission submitTask(Long taskId, String githubLink, Long userId,String jwt) throws Exception;

    Submission getTaskSubmissionById(Long submissionId) throws Exception;

    List<Submission> getAllTaskSubmissions();

    List<Submission> getTaskSubmissionsByTaskId(Long taskId);

    Submission acceptDeclineSubmission(Long id,String status) throws Exception;

}
