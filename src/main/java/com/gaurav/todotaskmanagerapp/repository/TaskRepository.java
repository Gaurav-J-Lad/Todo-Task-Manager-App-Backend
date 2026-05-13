package com.gaurav.todotaskmanagerapp.repository;

// ================= IMPORTS =================

import com.gaurav.todotaskmanagerapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// ================= TASK REPOSITORY =================
// Handles database operations for Task entity
// Extends JpaRepository to provide CRUD operations

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // =========================================================
    // GET TASKS BY USER ID (ORDERED BY CREATED DATE DESC)
    // Fetches all tasks of a user sorted by latest first
    // =========================================================

    List<Task> findByUserIdOrderByCreatedAtDesc(Long userId);
}