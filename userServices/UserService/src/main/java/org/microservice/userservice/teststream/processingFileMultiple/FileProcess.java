package org.microservice.userservice.teststream.processingFileMultiple;

import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class FileProcess {

    public static void main(String[] args) {

        final String sharedpath = "";
        final ExecutorService ex =  Executors.newFixedThreadPool(10);
        final AtomicInteger successCount = new AtomicInteger();
        final AtomicInteger failiureCount = new AtomicInteger();
        final AtomicInteger totalCount = new AtomicInteger();

        File[] files = new File(sharedpath).listFiles();

        if(files!=null){
            for(File file : files){
                 ex.execute(new DataProces(file.getAbsolutePath(),successCount,totalCount,failiureCount));
            }
        }

        ex.shutdown();

    }
}
