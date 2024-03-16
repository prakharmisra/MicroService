package org.microservice.userservice.teststream;

import java.util.ArrayList;
import java.util.List;

public class testper {
    public static void main(String[] args) {

        List<String> ls = new ArrayList<>();
        ls.add("delhi");
        ls.add("mumbai");
        ls.add("chennai");
        Person p  = new Person("rahul",22,ls);

        System.out.println(p.getAddr());

        p.getAddr().add("dsa");


    }
}
