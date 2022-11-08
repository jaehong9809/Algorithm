package BinarySearch;

import java.util.Scanner;

class NDB_27 {
    static int n, x;
    static int[] list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        x= sc.nextInt();
        list=new int[n];
        for (int i = 0; i < n; i++) {
            list[i]= sc.nextInt();
        }
        int a=lowerBound();
        int b=upperBound();
        int result=b-a;
        if(result==0){
            System.out.println(-1);
        }
        else{
            System.out.println(result);
        }
    }

    private static int upperBound() {
        int start=0;
        int end=list.length;
        while (start<end){
            int mid=(start+end)/2;
            if(x>=list[mid]){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }
        return end;
    }

    private static int lowerBound() {
        int start=0;
        int end=list.length;
        while (start<end){
            int mid=(start+end)/2;
            if(x<=list[mid]){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return end;
    }
}