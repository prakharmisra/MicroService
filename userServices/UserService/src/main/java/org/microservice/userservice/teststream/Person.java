package org.microservice.userservice.teststream;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;



@Getter
public class Person {

   private String name;
   private int age;

   private List<String> addr = new ArrayList<>();

   public Person(String name  , int age , List<String> addr   ){
       this.name = name;
       this.age = age;
       this.addr = addr;
   }

   public List<String> getAddr(){
       List<String> ls = new ArrayList<>();
       for(int i = 0 ; i < addr.size() ; i++){
           ls.add(addr.get(i));
       }
       return ls;
   }

}
