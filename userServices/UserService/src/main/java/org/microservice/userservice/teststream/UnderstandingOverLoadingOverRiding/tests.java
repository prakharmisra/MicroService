package org.microservice.userservice.teststream.UnderstandingOverLoadingOverRiding;

import org.microservice.userservice.teststream.StreamwithHashMapandstring.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class tests {
    public static void main(String[] args) {

        Employee ob = new Employee("a" , 1,"hr");
        Employee ob2 = new Employee("b" , 2,"hr");
        Employee ob3 = new Employee("c" , 3,"hr");

        Employee ob4 = new Employee("d" , 4,"dev");
        Employee ob5 = new Employee("e" , 5,"dev");
        Employee ob6 = new Employee("f" , 6,"dev");

        Employee ob7 = new Employee("g" , 7,"test");
        Employee ob8 = new Employee("h" , 8,"test");
        Employee ob9 = new Employee("e" , 9,"test");

        List<Employee> ls = new ArrayList<>();
        ls.add(ob);
        ls.add(ob2);
        ls.add(ob3);
        ls.add(ob4);
        ls.add(ob5);
        ls.add(ob6);
        ls.add(ob7);
        ls.add(ob8);
        ls.add(ob9);

       Map<String, List<Employee>> hm
               = ls.stream().collect(Collectors.groupingBy(Employee::getDepartment));




        hm.forEach((department, employeeList) -> {
            System.out.println("Department: " + department);
            employeeList.forEach(System.out::println);
            System.out.println();
        });

        int[] arr = {0,1,0,1,1,1,0,1,0};

          List<Integer> ans =  Arrays.stream(arr).boxed().collect(Collectors.toList());

        int i = 0 ;
        int j = 0;

        while( j < arr.length){

            if(arr[j]==0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
                i++;
            }
            else{
                j++;
            }
        }

        for(int val : arr){
            System.out.print(val + " ");
        }

    }
}

/*
   create a sample csv file with large


 */