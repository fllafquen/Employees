package com.employees.services;

import com.employees.model.Roles;
import com.employees.repository.UserRepository;
import com.employees.model.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.LinkedList;
import java.util.List;


@Service
public class UserServiceImpl extends Roles implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsersByInactiveWorkers() {
        return userRepository.getUsersByInactiveWorkers();
    }

    @Override
    public List<User> getUsersByDeletedWorkers() {
        return userRepository.getUsersByDeletedWorkers();
    }

    @Override
    public void updateUserByInactiveWorker(User user) {
        user.setStatus(INACTIVE);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUserByWorkerDeleted(Long id) {
        userRepository.removeDeleteStatuses(id);
    }
}
