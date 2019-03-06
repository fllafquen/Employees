package com.employees.domain;

import com.employees.model.entity.User;
import com.employees.services.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DesactivateUsersTask extends Task {

    private UserService userService;

    public DesactivateUsersTask(UserService userService) {
        this.userService = userService;
    }
    @Override
    public void execute() {
        List<User> inactiveWorkers = this.userService.getUsersByInactiveWorkers();
        for (User inactiveWorker: inactiveWorkers) {
            updateUserByInactiveWorker(inactiveWorker);
        }
    }

    private void updateUserByInactiveWorker(User user) { this.userService.updateUserByInactiveWorker(user); }
}
