package Implementation;

import java.util.Arrays;
import java.util.Scanner;

class BJ_16435 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int h=sc.nextInt();

        int[] arr=new int[n];

        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if(arr[i]<=h){
                h++;
            }else{
                break;
            }
        }
        System.out.println(h);
    }
}