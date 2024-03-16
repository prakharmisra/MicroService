package org.microservice.springsecurityjwt.Service;

import org.microservice.springsecurityjwt.Models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class UserService {
  List<User> store = new ArrayList<>();

  public UserService(){
      store.add(new User(UUID.randomUUID().toString(),"raj" , "raj@com"));
      store.add(new User(UUID.randomUUID().toString(),"prk" , "prk@com"));
      store.add(new User(UUID.randomUUID().toString(),"ram" , "ram@com"));
      store.add(new User(UUID.randomUUID().toString(),"mani" , "mani@com"));

  }

  public List<User> getUser(){
      return  this.store;
  }

}
