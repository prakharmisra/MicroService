package org.microservice.userservice.teststream.EvenOddPrinter;

public class main {
    public static void main(String[] args) {
        final int MAX_NUMBER = 10;
        Object lock = new Object();

        Thread evenThread = new Thread(new NumberPrinter(MAX_NUMBER, true, lock), "Even Thread");
        Thread oddThread = new Thread(new NumberPrinter(MAX_NUMBER, false, lock), "Odd Thread");

        evenThread.start();
        oddThread.start();
    }
}
