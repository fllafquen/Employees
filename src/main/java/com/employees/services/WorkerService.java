package com.employees.services;

import com.employees.model.entity.Worker;

import java.util.List;

public interface WorkerService {
    List<Worker> getOrphanWorkers();

    public void insertUserByWorker(Worker worker);
}
