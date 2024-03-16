package org.microservice.userservice.teststream.UnderstandingOverLoadingOverRiding;

public class TestChildClass extends TestOverLoading{

    public  void display(int a , int b){
        System.out.println(a + b + "hello");
        //return 5;
    }

    public static void main(String[] args) {
        String str1 = new String("hello");
        String str2 = new String("hello");

        StringBuilder sb = new StringBuilder(str1);

// Using equals method to compare content
        System.out.println(str1.equals(str2)); // Output: true (content comparison)

// Using equality operator to compare references
        System.out.println(str1 == str2);

        System.out.println(sb.equals(str1));
    }
}
