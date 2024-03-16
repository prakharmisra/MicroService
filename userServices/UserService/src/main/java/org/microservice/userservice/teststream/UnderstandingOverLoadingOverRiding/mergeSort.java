package org.microservice.userservice.teststream.UnderstandingOverLoadingOverRiding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class mergeSort {
    public static void main(String[] args) {

        int[] res = {1,5,2,5,2,6,8};

        int[] res2 = {1,5,2,5,2,6,8};
        List<Integer> ans =
                Arrays.stream(res).boxed().collect(Collectors.toCollection(ArrayList::new));

        List<Integer> ans2 =   helper(ans);

        for(Integer key : ans2){
            System.out.print(key + " ");
        }
        System.out.println();
        //bubble sort
        for(int i = 0 ; i < res2.length-1 ; i++){

            for(int j = 0 ; j < res2.length-1-i ; j++){

                if(res2[j]  > res2[j+1]){
                    int temp = res2[j+1];
                    res2[j+1] = res2[j];
                    res2[j] = temp;
                }
            }
        }

        for(Integer key : res2){
            System.out.print(key + " ");
        }


    }

    private static List<Integer> helper(List<Integer> ans) {

           if(ans.size()<=1){
               return  ans;
           }

            int mid = ans.size()/2;

            List<Integer> ls1 =  ans.subList(0,mid);
            List<Integer> ls2 =  ans.subList(mid,ans.size());

            List<Integer> ls1sort = helper(ls1);
            List<Integer> ls2ort = helper(ls2);


          return   mergeSorter(ls1sort,ls2ort);


    }

    private static ArrayList<Integer> mergeSorter(List<Integer> ls1, List<Integer> ls2) {

        ArrayList<Integer> fans = new ArrayList<>();
        int i = 0;
        int j = 0;

        while( i < ls1.size() && j < ls2.size()){

            if(ls1.get(i) < ls2.get(j)){
                fans.add(ls1.get(i));
                i++;
            }
            else{
                fans.add(ls2.get(j));
                j++;
            }
        }

        while(i < ls1.size()){
            fans.add(ls1.get(i));
            i++;
        }

        while(j < ls2.size()){
            fans.add(ls2.get(j));
            j++;
        }

        return fans;
    }
}
