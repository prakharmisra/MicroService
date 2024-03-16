package org.microservice.userservice.teststream;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class test {
    public static void main(String[] args) {
      /*  Find the first non repetitive character in
        String str = "Express";
        using java8 stream api
        Java8 stream API*/

        String str = "HELLO WORLD";

        Map<Character,Long> hm = str.chars()
                .mapToObj(val -> (char)val)
                .filter(val -> val !=  ' ')
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));

        Optional<Character> op = hm.entrySet().stream()
                .filter(val -> val.getValue() == 1)
                .map(Map.Entry::getKey)
                .skip(2)
                .findFirst();

        Person2 obj = new Person2(2,"prk");
        Person2 obj2 = new Person2(4,"raj");
        Person2 obj3 = new Person2(4,"prk");

        List<Person2> ls = new ArrayList<>();
        ls.add(obj2);
        ls.add(obj);
        ls.add(obj3);


        Map<String,Integer> hms = ls.stream().collect(Collectors.toMap(
        Person2::getName,Person2::getTrcount,Integer::sum));

        Map<String,Integer> hm2 = new HashMap<>();

        for(Person2 p :ls){
            String val = p.getName();

            hm2.merge(val,p.getTrcount(),Integer::sum);
        }

        System.out.println(hm2.toString() + " hellodfa");


        List<List<Integer>> lss = new ArrayList<>();
        lss.add(new ArrayList<>());

        lss.get(0).add(2);
        lss.get(0).add(5);

        List<Integer> ans = lss.stream().flatMap(Collection::stream)
                .toList();

        System.out.println(ans.get(0));

        int x = 12;
        boolean flag = IntStream.rangeClosed(2, (int) Math.sqrt(x)).noneMatch(n -> x%n==0);

        System.out.println(flag);

    }
}
