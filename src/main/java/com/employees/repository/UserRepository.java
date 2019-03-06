package com.employees.repository;

import com.employees.model.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Statement;
import java.util.List;

public interface UserRepository extends CrudRepository <User, Long> {

   @Query(value="select * from user where id in(select user_id from worker_users where worker_id in(select id from worker where status='INACTIVE'))", nativeQuery = true)
   public List<User> getUsersByInactiveWorkers();

   @Query(value="select * from user where id in(select user_id from worker_users where worker_id in(select id from worker where status='DELETED'))", nativeQuery = true)
   public List<User> getUsersByDeletedWorkers();

    @Modifying
    @Query(value="DELETE user,worker_users FROM user LEFT JOIN worker_users ON user.id=worker_users.user_id WHERE worker_users.user_id=?1", nativeQuery = true)
    void removeDeleteStatuses(Long id);

}
