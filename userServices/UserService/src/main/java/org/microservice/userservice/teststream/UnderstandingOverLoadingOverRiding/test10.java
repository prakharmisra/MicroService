package org.microservice.userservice.teststream.UnderstandingOverLoadingOverRiding;

public class test10 {

    public static void main(String[] args) {
        int[] a = {12,13,19};
        int[] b = {10,14,16,20};
        int[] ans = new int[a.length+b.length];
        int c = 0;
        int i = 0;
        int j = 0;
        while(i< a.length && j < b.length){
            if(a[i] > b[j]){
                ans[c] = b[j];
                j++;
                c++;
            }
            else{
                ans[c] = a[i];
                i++;
                c++;
            }
        }
        while( i< a.length){
            ans[c] = a[i];
            i++;
            c++;
        }
        while( j< b.length){
            ans[c] = b[j];
            j++;
            c++;
        }
        for(int ele : ans){
            System.out.print(ele + " ");
        }

    }
}
