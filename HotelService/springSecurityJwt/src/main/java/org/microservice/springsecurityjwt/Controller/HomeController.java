package org.microservice.springsecurityjwt.Controller;


import lombok.AllArgsConstructor;
import org.microservice.springsecurityjwt.Models.User;
import org.microservice.springsecurityjwt.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")

@AllArgsConstructor
//http://localhost:8081/home/users
public class HomeController {

    private UserService userService;

    @GetMapping("/users")
    public List<User> getUser(){

        System.out.println("user are printing");
        return userService.getUser();

    }

}
