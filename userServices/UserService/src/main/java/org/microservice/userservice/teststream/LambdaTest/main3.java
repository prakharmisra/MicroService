package org.microservice.userservice.teststream.LambdaTest;

public class main3 {
    public static void main(String[] args) {


        lambdatest lt = (a,b) -> System.out.println(a+b);

        lt.print(5,6);
    }
}
