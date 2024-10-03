package com.seval.task_submission_service.service;

import com.seval.task_submission_service.modal.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="USER-SERVICE",url="http://localhost:5001")
public interface UserService {
    @GetMapping("/api/users/profile")
    public UserDto getUserProfile(@RequestHeader("Authorization") String jwt);
}