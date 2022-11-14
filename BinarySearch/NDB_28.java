package BinarySearch;

import java.util.ArrayList;
import java.util.Scanner;

class NDB_28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp= sc.nextInt();
            data.add(tmp);
        }
        binarySearch(data);

    }

    private static void binarySearch(ArrayList<Integer> data) {
        int start=0;
        int end=data.size()-1;
        while (start<=end){
            int mid=(start+end)/2;
            System.out.printf("mid = %d, data[mid] =  %d\n", mid, data.get(mid));
            if(mid==data.get(mid)){
                System.out.println(mid);
                return;
            }
            if(mid>data.get(mid)){
                start=mid+1;
            }
            if(mid<data.get(mid)){
                end=mid-1;
            }
        }
        System.out.println(-1);
    }

}