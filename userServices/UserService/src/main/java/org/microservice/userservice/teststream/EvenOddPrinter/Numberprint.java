package org.microservice.userservice.teststream.EvenOddPrinter;

import lombok.AllArgsConstructor;
import org.hibernate.annotations.Synchronize;


public class Numberprint implements Runnable{

    Object lock;
   static  int number = 1;

    boolean isEven;

    int maxNumber;

    public Numberprint(int maxNumber , Object lock , boolean isEven){
        this.lock = lock;
        this.isEven = isEven;
        this.maxNumber = maxNumber;
    }
    @Override
    public void run() {

        while(number <= maxNumber) {
            synchronized (lock) {

                if(isEven && number%2==0 || !isEven && number%2!=0){
                    System.out.println(Thread.currentThread().getName() + " --" + number);
                    number++;
                    lock.notify();
                }
                else {
                    try{
                        lock.wait();
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();;
                    }
                }
            }

        }
    }
}
