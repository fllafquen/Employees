package com.employees.domain;

import com.employees.model.entity.Worker;
import com.employees.services.WorkerService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateUsersTask extends Task {
    private WorkerService workerService;

    public CreateUsersTask(WorkerService workerService) {
        this.workerService = workerService;
    }

    public void execute() {
        List<Worker> orphanWorkers = this.workerService.getOrphanWorkers();
        for (Worker orphanWorker: orphanWorkers) {
            createUserByWorker(orphanWorker);
        }
    }

    private void createUserByWorker(Worker worker) {
        this.workerService.insertUserByWorker(worker);
    }
}
