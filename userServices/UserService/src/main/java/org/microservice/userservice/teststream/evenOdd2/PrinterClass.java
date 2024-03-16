package org.microservice.userservice.teststream.evenOdd2;


import lombok.AllArgsConstructor;


public class PrinterClass implements Runnable{

    static  int number = 1;
    boolean isEven ;

    int maxNumber;

    Object lock;

    public  PrinterClass(int maxNumber , Object lock , boolean isEven){
        this.lock = lock;
        this.isEven = isEven;
        this.maxNumber = maxNumber;
    }

    @Override
    public void run() {

        while(number <= maxNumber){
            synchronized (lock){

                if(number%2==0 && isEven || number%2!=0 && !isEven){
                    System.out.println(number +"  --- thead" + Thread.currentThread().getName());
                    number++;
                    lock.notify();
                }
                else{
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
