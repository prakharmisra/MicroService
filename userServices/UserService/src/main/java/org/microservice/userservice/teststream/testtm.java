package org.microservice.userservice.teststream;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class testtm {
    public static void main(String[] args) {

        String ster  = "hello world is going to be an end";

        Map<Character,Long> hs = ster.chars().mapToObj(ch -> (char)ch).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));

        Optional<Character>  ch = hs.entrySet().stream().filter(key -> key.getKey()==1)
                .map(Map.Entry::getKey)
                .findFirst();


    }
}
