package com.gaurav.todotaskmanagerapp.service;

// ================= IMPORTS =================

import com.gaurav.todotaskmanagerapp.entity.Task;

import java.util.List;

// ================= TASK SERVICE INTERFACE =================
// Defines business operations for Task management
// Implemented by TaskServiceImpl (service layer)

public interface TaskService {

    // =========================================================
    // CREATE TASK
    // Saves a new task to database
    // =========================================================

    Task createTask(Task task);

    // =========================================================
    // GET TASKS BY USER ID
    // Returns all tasks for a specific user
    // =========================================================

    List<Task> getUserTasks(Long userId);

    // =========================================================
    // UPDATE TASK
    // Updates existing task by ID
    // =========================================================

    Task updateTask(Long id, Task task);

    // =========================================================
    // DELETE TASK
    // Removes task from database by ID
    // =========================================================

    void deleteTask(Long id);
}