package com.employees.domain;

import com.employees.services.UserService;
import com.employees.services.WorkerService;

abstract class Task {
    private UserService userService;
    private WorkerService workerService;

    abstract void execute();
}
