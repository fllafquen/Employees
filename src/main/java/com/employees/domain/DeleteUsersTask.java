package com.employees.domain;

import com.employees.model.entity.User;
import com.employees.services.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteUsersTask extends Task {
    private UserService userService;

    public DeleteUsersTask(UserService userService){
        this.userService = userService;
    }

    @Override
    public void execute() {

        List<User> usersToDelete = this.userService.getUsersByDeletedWorkers();
        for (User userToDelete: usersToDelete) {
                deleteUserByWorkerDeleted(userToDelete.getId());

        }
    }

    private void deleteUserByWorkerDeleted(Long id){
        this.userService.deleteUserByWorkerDeleted(id);
    }
}
