package org.microservice.userservice.Repositry;

import org.microservice.userservice.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepositry extends JpaRepository<User,String> {

    @Query(value = "Select u from User u where u.name > : age")
    public List<User> findByAgeGreaterThan(int age);
}
