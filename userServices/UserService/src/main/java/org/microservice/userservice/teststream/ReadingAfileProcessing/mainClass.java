package org.microservice.userservice.teststream.ReadingAfileProcessing;

import com.ctc.wstx.io.BufferRecycler;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class mainClass {
    public static void main(String[] args) {

        //"D:\TestReading.txt"

        String filePath = "D:\\TestReading.txt";

        Map<String,Integer> count_Map = new ConcurrentHashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){

                 br.lines().parallel().forEach(line -> {

                 String item = line.trim();
                 count_Map.merge(item,1,Integer::sum);
             });
        }
        catch (IOException e){
            e.printStackTrace();
        }

        count_Map.forEach((item,count) ->{
            System.out.println(item + " : " + count);
        });

        String filePaths = "D:\\TestOutput.txt";

        try(BufferedWriter brs = new BufferedWriter(new FileWriter(filePaths))){

            for(Map.Entry<String,Integer> key : count_Map.entrySet()){
                String keys = key.getKey();
                Integer count = key.getValue();
                brs.write(keys + " " + count);
                brs.newLine();
            }

            System.out.println("File Saved");
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
}
