package org.microservice.userservice.teststream.UnderstandingOverLoadingOverRiding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class test5 {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();

        stringList.add("australia");
        stringList.add("india");
        stringList.add("china");

        stringList.stream().filter(val -> val.startsWith("i")).forEach(System.out::println);
       /*
       input = {1,2,3,4,2,3,4}, output = {1,2,3,4,_,_,_}
        */

       int[] input = {1,5,2,2,7,1};
       //1,2,5,7,_,_
       String[] output = new String[input.length];

       Arrays.sort(input);
       int c = 0;

       int k = 0;
       while( k < input.length){
           output[c] = Integer.toString(input[k]);
           c++;
           int val = input[k];
           while( k < input.length && val==input[k]){
               k++;
           }
       }

       for(int  i = 0 ; i < output.length ; i++){
           int val = 0;
           if(output[i]!=null) {
               val = Integer.parseInt(output[i]);
           }
           if(val==0){

               output[c] = "_";
               c++;
           }
       }

       for(String itr : output){
           System.out.print(itr + " ");
       }







    }
}
