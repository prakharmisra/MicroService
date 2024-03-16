package org.microservice.userservice.teststream.UnderstandingOverLoadingOverRiding;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        List<Student> sortList = new ArrayList<>();

        Student ob1 = new Student("shiva",1,23);
        Student ob2 = new Student("prk", 2 , 26);
        Student ob3 = new Student("raj" , 3 , 29);




        sortList.add(ob1);
        sortList.add(ob3);
        sortList.add(ob2);

                List<Student> finalList =
                sortList.stream()
                        .sorted((a,b) -> a.age-b.age).collect(Collectors.toList());

      /*  for(Student st : finalList){
            System.out.println(st.toString());
        }
*/
        double n  = 1234.567;

        System.out.println(helper(n));;

    }

    private static int helper(double n) {

        int sumOfDig = 0;
        while( n > 0){
            sumOfDig += n%10;
            n = n/10;
        }

        if(sumOfDig >= 10){
            System.out.println(sumOfDig + " dig ");
            return  helper(sumOfDig);
        }

        return sumOfDig;
    }
}
