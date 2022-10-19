package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class BJ_1920 {
    static int n;
    static int m;
    static ArrayList<Integer> ary = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n= sc.nextInt();
        for (int i = 0; i < n; i++) {
            ary.add(sc.nextInt());
        }
        Collections.sort(ary);
        m= sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a= sc.nextInt();
            if(binarySearch(a)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }

    }

    public static boolean binarySearch(int x){
        int start=0;
        int end=ary.size()-1;   //이거 조심하자 배열 인덱스 생각
        while(start<=end){
            int mid=(start+end)/2;
            if(ary.get(mid)==x)return true;
            else if (ary.get(mid)>x) {
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return false;
    }
}