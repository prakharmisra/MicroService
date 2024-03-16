package org.microservice.redish.Model;


import lombok.Data;

@Data
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
}
