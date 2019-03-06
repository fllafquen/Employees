package com.employees.scheduling;

import com.employees.domain.CreateUsersTask;
import com.employees.domain.DeleteUsersTask;
import com.employees.domain.DesactivateUsersTask;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    private CreateUsersTask createUsersTask;
    private DeleteUsersTask deleteUsersTask;
    private DesactivateUsersTask desactivateUsersTask;

    /**
     * @param createUsersTask {@link CreateUsersTask}
     * @param deleteUsersTask {@link DeleteUsersTask}
     * @param desactivateUsersTask {@link DesactivateUsersTask}
     */
    public Scheduler(CreateUsersTask createUsersTask, DeleteUsersTask deleteUsersTask, DesactivateUsersTask desactivateUsersTask) {
        this.createUsersTask = createUsersTask;
        this.deleteUsersTask = deleteUsersTask;
        this.desactivateUsersTask = desactivateUsersTask;
    }

    @Scheduled(cron = "* */15 * * * *")
    public void createUserForOrphanWorkers() {
        this.createUsersTask.execute();
    }

    @Scheduled(cron = "* */20 * * * *")
    public void desactiveInactiveUsers() {
        this.desactivateUsersTask.execute();
    }

    @Scheduled(cron = "0 0 0 * * 0")
    public void deleteUsersByDeletedWorkers() {
        this.deleteUsersTask.execute();
    }
}
