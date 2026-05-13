package com.gaurav.todotaskmanagerapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class HomeController {

    // ================= HOME PAGE (TEXT RESPONSE) =================
    // URL: GET /

    @GetMapping(value = "/", produces = "text/plain")
    public String home() {

        return """
                🚀 Todo Task Manager Backend is Running Successfully!

                ================= AUTH APIs =================
                POST   /api/auth/register   -> Register User
                POST   /api/auth/login      -> Login User

                ================= TASK APIs =================
                POST   /api/tasks           -> Create Task
                GET    /api/tasks/user/{id} -> Get Tasks by User
                PUT    /api/tasks/{id}      -> Update Task
                DELETE /api/tasks/{id}      -> Delete Task

                ================= STATUS =================
                Server is up and running ✔
                """;
    }
}