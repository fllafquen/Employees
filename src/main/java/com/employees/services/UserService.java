package com.employees.services;

import com.employees.model.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsersByInactiveWorkers();

    List<User> getUsersByDeletedWorkers();

    public void updateUserByInactiveWorker(User user);

    public void deleteUserByWorkerDeleted(Long id);

}
