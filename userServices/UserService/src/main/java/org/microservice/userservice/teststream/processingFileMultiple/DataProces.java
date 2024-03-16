package org.microservice.userservice.teststream.processingFileMultiple;

import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class DataProces implements Runnable {

   private final String fileName;
   private final AtomicInteger successCount ;
   private final AtomicInteger failiureCount ;
   private final AtomicInteger totalCount;



    @Override
    public void run() {

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){

            br.lines().parallel().forEach(line -> {
                boolean result = false; //processtheLine(line);
                totalCount.getAndIncrement();

                if(!result){
                    failiureCount.getAndIncrement();
                }
                else{
                    successCount.getAndIncrement();
                }



            });


        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
