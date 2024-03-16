package org.microservice.userservice.teststream.evenOdd2;

import com.ctc.wstx.shaded.msv_core.verifier.jarv.TheFactoryImpl;

public class mainClass {

    public static void main(String[] args) {
        Object lock  = new Object();
        int maxNumber = 10;

        Thread t1 = new Thread(new PrinterClass(maxNumber,lock,true));
        Thread t2 = new Thread(new PrinterClass(maxNumber,lock,false));

        t1.start();
        t2.start();
    }
}
