package org.microservice.userservice.teststream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class testey {
    public static void main(String[] args) {
       String str = "india";
        Map<Character,Integer> hm = new LinkedHashMap<>();
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        System.out.println(hm.toString());
        Integer[] ans = {2,4,7,9,8};
        List<Integer> ls = Arrays.stream(ans).filter(val -> val%2==0)
                .map(val -> val*val)
                .collect(Collectors.toList());
        System.out.println(ls);
    }

}
