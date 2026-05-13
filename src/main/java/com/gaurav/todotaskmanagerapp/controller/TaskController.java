package com.gaurav.todotaskmanagerapp.controller;

// ================= IMPORTS =================

import com.gaurav.todotaskmanagerapp.entity.Task;
import com.gaurav.todotaskmanagerapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ================= TASK CONTROLLER =================
// Handles all CRUD operations for Task management

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin("*")
public class TaskController {

    // ================= SERVICE INJECTION =================
    // Business logic handled in TaskService layer

    @Autowired
    private TaskService service;

    // =========================================================
    // CREATE TASK
    // URL: POST /api/tasks
    // =========================================================

    @PostMapping
    public Task create(@RequestBody Task task) {

        // Create new task using service
        return service.createTask(task);
    }

    // =========================================================
    // GET TASKS BY USER ID
    // URL: GET /api/tasks/user/{userId}
    // =========================================================

    @GetMapping("/user/{userId}")
    public List<Task> get(@PathVariable Long userId) {

        // Fetch all tasks for a specific user
        return service.getUserTasks(userId);
    }

    // =========================================================
    // UPDATE TASK
    // URL: PUT /api/tasks/{id}
    // =========================================================

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task t) {

        // Update task details by ID
        return service.updateTask(id, t);
    }

    // =========================================================
    // DELETE TASK
    // URL: DELETE /api/tasks/{id}
    // =========================================================

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        // Delete task by ID
        service.deleteTask(id);

        // Return empty success response
        return ResponseEntity.ok().build();
    }
}