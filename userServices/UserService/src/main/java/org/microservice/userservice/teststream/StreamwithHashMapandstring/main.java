package org.microservice.userservice.teststream.StreamwithHashMapandstring;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.microservice.userservice.teststream.Person2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class main {

    public static void main(String[] args) {

        /*
          find duplicate in string first , second or non - rep
         */

        String ip = "hello i am prakhar";

        HashMap<Character,Long> hm
                = ip.chars().mapToObj(c -> (char)c)
                .filter(a -> a != ' ')
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));

         Optional<Character> ans = hm.entrySet().stream()
                 .filter(a -> a.getValue() == 1)
                 .map(Map.Entry::getKey)
                 .findFirst();

      //sort the character using tree set
        TreeSet<Character> hs
                = ip.chars().mapToObj(c -> (char)c)
                .filter(a -> a != ' ')
                .collect(Collectors.toCollection(TreeSet::new));

       // Character ans1 = ip.chars().filter(new HashSet<>()::add).findFirst();

        //hs.forEach(System.out::print);


        Employee ob = new Employee("a" , 1,"hr");
        Employee ob2 = new Employee("b" , 2,"hr");
        Employee ob4 = new Employee("d" , 4,"dev");
        Employee ob5 = new Employee("e" , 5,"dev");
        Employee ob7 = new Employee("g" , 7,"test");
        Employee ob8 = new Employee("h" , 8,"test");
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(ob);
        employeeList.add(ob2);
        employeeList.add(ob4);
        employeeList.add(ob5);
        employeeList.add(ob7);
        employeeList.add(ob8);

        //simple grouping employee on dep level

        TreeMap<String,List<Employee>>
                employeeTreeMap
                = employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,TreeMap::new,Collectors.toList()));

        employeeTreeMap.forEach((department, employeeLists) -> {
            System.out.println("Department: " + department);
          //  employeeLists.forEach(System.out::println);
           // System.out.println();
        });

        Map<String,List<Employee>>
                employeeHashMap
                = employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        employeeHashMap.forEach((department, employeeLists) -> {
            System.out.println("Department: " + department);
            //employeeLists.forEach(System.out::println);
           // System.out.println();
        });

        emp obj = new emp(2,"prk");
        emp obj2 = new emp(4,"raj");
        emp  obj3 = new emp(4,"prk");

        List<emp> ls = new ArrayList<>();
        ls.add(obj2);
        ls.add(obj);
        ls.add(obj3);
        Map<String,Integer> hashMap =
                ls.stream()
                        .collect(Collectors.toMap(emp::getName,emp::getTrcount,Integer::sum));

      //Integer to check prime or not

        double a = 7;

        boolean res = IntStream.rangeClosed(2,(int)Math.sqrt(a))
                .noneMatch(val -> a%val != 0);

        Map<String,Integer> hashMaps =
                ls.stream()
                        .collect(Collectors.toMap(emp::getName,e ->1,Integer::sum));

    //to store using merge function
        Integer[] arr=new Integer[5];
        // int a=arr[1];
        // System.out.println(a);

        List<Integer> resss= new ArrayList<>();
        resss.add(4);
        resss.add(12);
        resss.add(12);
        resss.add(4);
        resss.add(3);

        HashSet<Integer> hsa = new HashSet<>();
        Integer number
                 = resss.stream().filter(e -> resss.indexOf(e) == resss.lastIndexOf(e)).findFirst().orElse(null);
        System.out.println(number);

        String str2 =  "this is prakahr misra 1,2,3 ";

        String[] str3 = str2.split(" ");

        List<String> token = Arrays.stream(str3).toList();

        System.out.println(token.get(4).split(",")[0]);

        /*
        ```````````````````String[]  ```````````````````str ={"java", "JAVA","anguLar","AnguLar"}
         */

        String[] str = {"java", "JAVA","anguLar","AnguLar"};
      /*  HashMap<String,Integer> hm = new HashMap<>();
                Arrays.stream(str).map(val -> val.toUpperCase())
                        .forEach(val ->{
                            hm.merge(val,1,Integer::sum);
                        });

        System.out.println(hm.toString());*/
        Map<String,Long> hmsds = Arrays.stream(str)
                .map(val -> val.toUpperCase())
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        String strs = "India is Awesome";
     //   strs = strs.toUpperCase();

        HashMap<Character,Long> hmnas =
                strs.chars().mapToObj(c -> (char)c)
                        .filter(val -> val!=' ')
                        .collect(Collectors.groupingBy(
                           Function.identity(),LinkedHashMap::new,Collectors.counting()
                        ));

        Character ch = hmnas.entrySet().stream()
                .filter(val -> val.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);


        System.out.println(hmnas.toString() + " ans");



    }
}
