package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class BJ_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] data=new int[n];
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            data[i]=Integer.parseInt(s[i]);
            set.add(data[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int cnt=0;
        for (Integer integer : set) {
            map.put(integer, cnt++);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(map.get(data[i])).append(" ");
        }
        System.out.println(sb);
    }
    public static int lowerBound(List<Integer> list, int target){
        int start=0;
        int end=list.size();

        while (start<end){
            int mid=(start+end)/2;

            if(list.get(mid)>=target){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return end;
    }
}

