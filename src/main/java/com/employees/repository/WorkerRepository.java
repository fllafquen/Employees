package com.employees.repository;

import com.employees.model.entity.Worker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkerRepository extends CrudRepository<Worker, Long> {
    @Query("SELECT w FROM Worker w WHERE w.users is empty")
    public List<Worker> getOrphanWorkers();
}
