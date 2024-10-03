package com.seval.task_submission_service.service;

import com.seval.task_submission_service.modal.Submission;
import com.seval.task_submission_service.modal.TaskDto;
import com.seval.task_submission_service.repository.SubmissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class SubmissionServiceImplementation implements SubmissionService{

    private final SubmissionRepository submissionRepository;

    private final TaskService taskService;

    @Override
    public Submission submitTask(Long taskId, String githubLink, Long userId,String jwt) throws Exception {
        TaskDto task=taskService.getTaskById(taskId,jwt);
            if(task!=null){
                Submission submission=new Submission();
                submission.setTaskId(taskId);
                submission.setUserId(userId);
                submission.setGithubLink(githubLink);
                submission.setSubmissionTime(LocalDateTime.now());
                return submissionRepository.save(submission);

            }
            throw new Exception("Task not found with id: "+ taskId);
    }

    @Override
    public Submission getTaskSubmissionById(Long submissionId) throws Exception {
        return submissionRepository.findById(submissionId).orElseThrow(()->
                new Exception("Task Submission not found with id "+submissionId));
    }

    @Override
    public List<Submission> getAllTaskSubmissions() {
        return submissionRepository.findAll();
    }

    @Override
    public List<Submission> getTaskSubmissionsByTaskId(Long taskId) {
        return submissionRepository.findByTaskId(taskId);
    }

    @Override
    public Submission acceptDeclineSubmission(Long id, String status) throws Exception {
        Submission submission=getTaskSubmissionById(id);
        submission.setStatus(status);
        if(status.equals("ACCEPT")) {
            taskService.completeTask(submission.getTaskId());
        }
        return submissionRepository.save(submission);
    }
}
