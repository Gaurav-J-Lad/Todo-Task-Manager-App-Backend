package com.gaurav.todotaskmanagerapp.service;

// ================= IMPORTS =================

import com.gaurav.todotaskmanagerapp.entity.User;

// ================= USER SERVICE INTERFACE =================
// Defines business operations for User authentication

public interface UserService {

    // =========================================================
    // USER REGISTRATION
    // Creates a new user in the system
    // =========================================================

    User register(User user);

    // =========================================================
    // USER LOGIN
    // Validates username and password for authentication
    // =========================================================

    User login(String username, String password);
}