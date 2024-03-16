package org.microservice.userservice.teststream.EvenOddPrinter;

public class main2 {
    public static void main(String[] args) {

       final  int maxNumber = 100;
       Object lock = new Object();

        Numberprint even = new Numberprint(maxNumber,lock , true);
        Numberprint odd = new Numberprint(maxNumber,lock , false);

        Thread t1 = new Thread(even);
        Thread t2 = new Thread(odd);

        t1.start();
        t2.start();

    }
}
