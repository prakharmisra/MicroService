package org.microservice.userservice.Models;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "User")
public class User {


    @Id
    @Column(name = "ID" )
    private String uid;

    @Column(name = "NAME" , length = 15)
    private String name ;

    private String Email;

    private String about;


    @Transient//this annotatins tell we dont want to store this in database
    private List<Rating> ratingList  = new ArrayList<>();



}
