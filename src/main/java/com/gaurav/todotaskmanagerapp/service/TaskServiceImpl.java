package com.gaurav.todotaskmanagerapp.service;

// ================= IMPORTS =================

import com.gaurav.todotaskmanagerapp.entity.Task;
import com.gaurav.todotaskmanagerapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// ================= SERVICE IMPLEMENTATION =================
// Implements business logic for Task management operations

@Service
public class TaskServiceImpl implements TaskService {

    // ================= REPOSITORY INJECTION =================
    // Handles all database operations for Task entity

    @Autowired
    private TaskRepository repo;

    // =========================================================
    // CREATE TASK
    // Saves new task into database
    // =========================================================

    public Task createTask(Task task) {
        return repo.save(task);
    }

    // =========================================================
    // GET TASKS BY USER ID
    // Returns all tasks for a user ordered by latest first
    // =========================================================

    public List<Task> getUserTasks(Long userId) {
        return repo.findByUserIdOrderByCreatedAtDesc(userId);
    }

    // =========================================================
    // UPDATE TASK
    // Updates existing task fields by ID
    // =========================================================

    public Task updateTask(Long id, Task data) {

        // Fetch existing task or throw exception if not found
        Task task = repo.findById(id).orElseThrow();

        // Update editable fields
        task.setTitle(data.getTitle());
        task.setDescription(data.getDescription());
        task.setDueDate(data.getDueDate());

        // Save updated task
        return repo.save(task);
    }

    // =========================================================
    // DELETE TASK
    // Removes task from database by ID
    // =========================================================

    public void deleteTask(Long id) {
        repo.deleteById(id);
    }
}