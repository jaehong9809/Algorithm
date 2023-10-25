package Implementation;

import java.util.Scanner;

class BJ_2003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        int cnt=0;
        for (int i = 0; i < n; i++) {
            int sum=0;
            for (int j = i; j < n; j++) {
                sum+=list[j];
                if(sum==m){
                    cnt++;
                    break;
                }
                if(sum>m){
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}