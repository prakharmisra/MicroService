package org.microservice.userservice.Service;

import org.microservice.userservice.Models.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);

}
