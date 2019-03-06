package test.com.employees.domain;

import com.employees.domain.CreateUsersTask;
import com.employees.model.entity.Worker;
import com.employees.repository.WorkerRepository;
import com.employees.services.WorkerService;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * CreateUsersTask Tester.
 *
 * @author <Authors name>
 * @since <pre>mar 1, 2019</pre>
 * @version 1.0
 */

@RunWith(Parameterized.class)
public class CreateUsersTaskTest {
    @Autowired
    private WorkerService workerService;

    private WorkerRepository workerRepository;

    public CreateUsersTaskTest(WorkerService workerService) {
        this.workerService = workerService;
    }


    @Test
    public void testExecuteGetOrphanWorkers() throws Exception {
        List<Worker> results = workerService.getOrphanWorkers();
        assertThat(results.size(), is(5));
    }

} 
