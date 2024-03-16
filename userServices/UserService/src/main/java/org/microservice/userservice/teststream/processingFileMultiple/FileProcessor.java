package org.microservice.userservice.teststream.processingFileMultiple;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class DataProcessorTask implements Runnable {
    private final String fileName;
    private final AtomicInteger successCount;
    private final AtomicInteger failureCount;
    private final AtomicInteger totalCount;

    public DataProcessorTask(String fileName, AtomicInteger successCount, AtomicInteger failureCount, AtomicInteger totalCount) {
        this.fileName = fileName;
        this.successCount = successCount;
        this.failureCount = failureCount;
        this.totalCount = totalCount;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                boolean result = false;//"com.acme.ai.DataProcessor.parse(line)";
                totalCount.incrementAndGet();
                if (result) {
                    successCount.incrementAndGet();
                } else {
                    failureCount.incrementAndGet();
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + fileName);
        }
    }
}

public class FileProcessor {
    public static void main(String[] args) {
        final String sharedDirectory = "path/to/shared/directory";
        final ExecutorService executor = Executors.newFixedThreadPool(10); // Adjust the number of threads as per your requirement
        final AtomicInteger successCount = new AtomicInteger(0);
        final AtomicInteger failureCount = new AtomicInteger(0);
        final AtomicInteger totalCount = new AtomicInteger(0);



        File[] files = new File(sharedDirectory).listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    executor.execute(new DataProcessorTask(file.getAbsolutePath(), successCount, failureCount, totalCount));
                }
            }
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait for all threads to finish
        }

        // Logging results
        System.out.println("Log format: fileName - true: <count>; false: <count>; failed: <count>");
        System.out.println("Total files processed: " + files.length);
        System.out.println("Total lines processed: " + totalCount.get());
        System.out.println("Total successful lines: " + successCount.get());
        System.out.println("Total failed lines: " + failureCount.get());
    }
}
