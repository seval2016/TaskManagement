package com.seval.task_submission_service.controller;

import com.seval.task_submission_service.modal.Submission;
import com.seval.task_submission_service.modal.TaskStatus;
import com.seval.task_submission_service.modal.UserDto;
import com.seval.task_submission_service.service.SubmissionService;
import com.seval.task_submission_service.service.TaskService;
import com.seval.task_submission_service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
@AllArgsConstructor
public class Submissioncontroller {

    private final SubmissionService submissionService;
    private final UserService userService;
    private final TaskService taskService;

    @PostMapping()
    public ResponseEntity<Submission> submitTask(
            @RequestParam Long taskId,
            @RequestParam String githubLink,
            @RequestHeader("Authorization") String jwt
    ) throws Exception {
        UserDto user = userService.getUserProfile(jwt);
        Submission submission = submissionService.submitTask(taskId, githubLink, user.getId(), jwt);
        return new ResponseEntity<>(submission, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Submission> getTaskSubmissionById(
            @PathVariable Long taskId,
            @RequestHeader("Authorization") String jwt
    ) throws Exception {
        UserDto user = userService.getUserProfile(jwt);
        Submission submissionTask = submissionService.getTaskSubmissionById(taskId);
        return new ResponseEntity<>(submissionTask, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Submission>> getAllTaskSubmissions(
            @RequestHeader("Authorization") String jwt
    ) throws Exception {
        UserDto user = userService.getUserProfile(jwt);
        List<Submission> submissionTasks = submissionService.getAllTaskSubmissions();
        return new ResponseEntity<>(submissionTasks, HttpStatus.OK);
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<Submission>>getTaskSubmissionsByTaskId(
            @PathVariable Long taskId,
            @RequestHeader("Authorization") String jwt
    ) throws Exception {
        UserDto user = userService.getUserProfile(jwt);
        List<Submission> submissionTasks = submissionService.getTaskSubmissionsByTaskId(taskId);
        return new ResponseEntity<>(submissionTasks, HttpStatus.OK);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Submission> acceptDeclineSubmission(
            @PathVariable Long taskId,
            @RequestParam String status,
            @RequestHeader("Authorization") String jwt
    )throws Exception {
        UserDto user = userService.getUserProfile(jwt);
        Submission declinedTask=submissionService.acceptDeclineSubmission(taskId,status);
        return new ResponseEntity<>(declinedTask, HttpStatus.OK);
    }

}
