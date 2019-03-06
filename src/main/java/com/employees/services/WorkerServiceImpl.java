package com.employees.services;

import com.employees.model.Roles;
import com.employees.model.entity.User;
import com.employees.repository.WorkerRepository;
import com.employees.model.entity.Worker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl extends Roles implements WorkerService {
    private WorkerRepository workerRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public List<Worker> getOrphanWorkers() {

        return workerRepository.getOrphanWorkers();
    }

    @Override
    public void insertUserByWorker(Worker worker) {
        User newUser = new User();
        newUser.setUsername(worker.getName());
        newUser.setPassword(worker.getName());
        newUser.setStatus(worker.getStatus());
        newUser.setType(TYPEWORKER);

        worker.addUser(newUser);
        workerRepository.save(worker);
    }
}
