package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//범위를 잊지말자 int , long
class BJ_2805 {
    static ArrayList<Integer> ary = new ArrayList<>();
    static int n, m;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n= sc.nextInt();
        m= sc.nextInt();
        for (int i = 0; i < n; i++) {
            ary.add(sc.nextInt());
        }
        Collections.sort(ary);

        binarySearch(m);
    }

    public static void binarySearch(int m){
        long start=0;       //이걸왜 0을 생각못하니
        long end=ary.get(ary.size()-1);
        long result=0;

        while(start<=end){
            long mid=(start+end)/2;
            long total=0;
            for (Integer integer : ary) {
                if(integer>mid){
                    total += (integer - mid);
                }
            }

           if (total>=m){
               result=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        System.out.println(result);
    }
}



