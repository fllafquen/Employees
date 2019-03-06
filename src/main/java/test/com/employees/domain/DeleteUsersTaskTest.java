package test.com.employees.domain; 

import com.employees.domain.CreateUsersTask;
import com.employees.model.entity.User;
import com.employees.repository.UserRepository;
import com.employees.repository.WorkerRepository;
import com.employees.services.UserService;
import com.employees.services.WorkerService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/** 
* DeleteUsersTask Tester. 
* 
* @author <Authors name> 
* @since <pre>mar 1, 2019</pre> 
* @version 1.0 
*/
@RunWith(Parameterized.class)
public class DeleteUsersTaskTest {
    @Autowired
    private UserService userService;

    private UserRepository userRepository;

    public DeleteUsersTaskTest(UserService userService) {
        this.userService = userService;
    }


@Test
public void testDeleteUserByWorkerDeleted() throws Exception {
    List<User> usersToDelete = this.userService.getUsersByDeletedWorkers();
        assertThat(usersToDelete.size(), is(8));
} 

} 
