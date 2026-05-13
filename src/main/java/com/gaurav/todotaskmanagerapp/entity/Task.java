package com.gaurav.todotaskmanagerapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Task {

    // ================= PRIMARY KEY =================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    // ================= TASK TITLE =================
    @Column(name = "title", nullable = false, length = 150)
    private String title;

    // ================= TASK DESCRIPTION =================
    @Column(name = "description", length = 500)
    private String description;

    // ================= COMPLETION STATUS =================
    @Column(name = "completed", nullable = false)
    private boolean completed = false;

    // ================= DUE DATE =================
    @Column(name = "due_date")
    private LocalDate dueDate;

    // ================= CREATION TIMESTAMP =================
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // ================= USER REFERENCE =================
    // Stores owner of task (simple FK reference, not entity relation)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    // ================= AUTO TIMESTAMP SET =================
    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}