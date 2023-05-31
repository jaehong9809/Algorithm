package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class BJ_1920_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            data.add(sc.nextInt());
        }
        n= sc.nextInt();
        Collections.sort(data);
        for (int i = 0; i < n; i++) {
            int input=sc.nextInt();
            int i1 =binarySearch(data, input);
            if(i1<0) System.out.println(0);
            else System.out.println(1);
        }

    }
    public static int binarySearch(ArrayList<Integer> data, int input){
        int start=0;
        int end=data.size()-1;
        while (start<=end){
            int mid=(start+end)/2;
            if(data.get(mid)<input){
                start=mid+1;
            }
            if(data.get(mid)>input){
                end=mid-1;
            }
            if(data.get(mid)==input){
                break;
            }
        }
        if(start>end){
            return -1;
        }
        return end;
    }
}