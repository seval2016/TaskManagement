package com.seval.task_submission_service.controller;

import com.seval.task_submission_service.modal.Submission;
import com.seval.task_submission_service.modal.UserDto;
import com.seval.task_submission_service.service.SubmissionService;
import com.seval.task_submission_service.service.TaskService;
import com.seval.task_submission_service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/submissions")
@AllArgsConstructor
public class Submissioncontroller {

    private final SubmissionService submissionService;
    private final UserService userService;
    private final TaskService taskService;

    @PostMapping("/")

    public ResponseEntity<Submission> submitTask(@PathVariable Long taskId,
                                                 @RequestParam String github_link,
                                                 @RequestHeader("Authorization") String jwt) throws Exception {
        UserDto user = userService.getUserProfile(jwt);
        Submission submission = submissionService.submitTask(taskId, github_link, user.getId(), jwt);

        return new ResponseEntity<>(submission, HttpStatus.OK);
    }

}
