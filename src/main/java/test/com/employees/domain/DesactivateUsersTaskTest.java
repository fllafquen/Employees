package test.com.employees.domain; 

import com.employees.model.entity.User;
import com.employees.repository.UserRepository;
import com.employees.services.UserService;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/** 
* DesactivateUsersTask Tester. 
* 
* @author <Authors name> 
* @since <pre>mar 1, 2019</pre> 
* @version 1.0 
*/
@RunWith(Parameterized.class)
public class DesactivateUsersTaskTest {
    @Autowired
    private UserService userService;

    private UserRepository userRepository;

    public DesactivateUsersTaskTest(UserService userService) {
        this.userService = userService;
    }
    @Test
    public void testUpdateUserByInactiveWorker() throws Exception {
        List<User> inactiveWorkers = this.userService.getUsersByInactiveWorkers();
        assertThat(inactiveWorkers.size(), is(5));
    }
}
