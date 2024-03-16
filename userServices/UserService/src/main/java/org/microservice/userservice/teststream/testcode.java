package org.microservice.userservice.teststream;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class testcode {

   public static class Node {

       int data;
       Node left;
       Node right;

       public Node(int data){
           this.data =data;
           this.left = null;
           this.right = null;
       }
    }
    public static void main(String[] args) {
       String str = "absdsadkahdfhfoewfudoidj";
        TreeMap<Character,Integer> tm = new TreeMap<>();

        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            tm.put(ch , tm.getOrDefault(ch,0)+1);
        }

        String strs = "";
        for(Map.Entry<Character,Integer> key : tm.entrySet()){

            int val = key.getValue();
            char ch = key.getKey();

            while(val > 0){
                strs+=ch;
                val--;
            }
        }

        System.out.println(strs);

    }
}
