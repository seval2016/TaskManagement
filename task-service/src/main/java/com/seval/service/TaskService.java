package com.seval.service;

import com.seval.modal.Task;
import com.seval.modal.TaskStatus;

import java.util.List;

public interface TaskService {

    Task createTask(Task task,String requestRole) throws Exception;

    Task getTaskById(Long id) throws Exception;

     List<Task> getAllTask(TaskStatus status);

     Task updateTask(Long id,Task updatedTask,Long uswerId) throws Exception;

     void deleteTask(Long id) throws Exception;

     Task assignedToUser(Long userId,Long taskId)throws Exception;

     List<Task> assignedUsersTask(Long userId, TaskStatus status);

     Task completeTask (Long taskId)throws Exception;
}
