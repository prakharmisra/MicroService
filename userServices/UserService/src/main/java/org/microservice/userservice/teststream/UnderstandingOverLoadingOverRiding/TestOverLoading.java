package org.microservice.userservice.teststream.UnderstandingOverLoadingOverRiding;

public class TestOverLoading {

    public void display(int a , int b){
        System.out.println(a +b);
    }

    public void display(int a , int b  , int c){
        System.out.println(a +b);

        //return a+ b + c;
    }

}
