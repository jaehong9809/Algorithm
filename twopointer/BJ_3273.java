package twopointer;

import java.util.Arrays;
import java.util.Scanner;

class BJ_3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] data=new int[n];

        for (int i = 0; i < n; i++) {
            data[i]=sc.nextInt();
        }
        Arrays.sort(data);
        int x=sc.nextInt();
        int cnt=0;
        int start=0;
        int end=n-1;
        while (start<end){
            int sum=data[start]+data[end];
            if(sum==x){
                start++;
                end--;
                cnt++;
            }else if(sum<x){
                start++;
            }else{
                end--;
            }
        }
        /*Map<Integer, Integer> map = new TreeMap<>();
        int cnt=0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(x-data[i])) {
                map.put(data[i], x-data[i]);
            }else{
                Integer integer = map.get(x - data[i]);
                if(integer==data[i])cnt++;
            }
        }*/
        System.out.println(cnt);
    }
}