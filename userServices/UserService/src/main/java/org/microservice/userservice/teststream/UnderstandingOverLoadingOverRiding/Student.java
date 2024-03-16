package org.microservice.userservice.teststream.UnderstandingOverLoadingOverRiding;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Student {

    String name;
    int id;

    int age;

   public String toString(){

       return  this.name + " " + this.id + " " + this.age;
   }

}
