package org.microservice.userservice.teststream.EvenOddPrinter;

class NumberPrinter implements Runnable {
    private final int maxNumber;
    private final boolean isEven;
    private static int number = 1;
    private final Object lock;

    public NumberPrinter(int maxNumber, boolean isEven, Object lock) {
        this.maxNumber = maxNumber;
        this.isEven = isEven;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (number <= maxNumber) {
            synchronized (lock) {
                // Check if the number matches the required even/odd condition
                if ((isEven && number % 2 == 0) || (!isEven && number % 2 != 0)) {
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;
                   // lock.notify(); // Notify the waiting thread
                } /*else {
                    try {
                      //  lock.wait(); // Wait for the other thread to print its number
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/
            }
        }

    }
}