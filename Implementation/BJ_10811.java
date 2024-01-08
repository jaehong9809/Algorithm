package Implementation;

import java.util.Scanner;

class BJ_10811 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        Integer[] data=new Integer[n+1];
        for (int i = 1; i <= n; i++) {
            data[i]=i;
        }
        for (int i = 0; i < m; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int[] tmp = new int[n+1];
            int index=a;
            for (int j = b; j >=a ; j--) {
                tmp[index]=data[j];
                index++;
            }
            for (int j = a; j <=b ; j++) {
                data[j]=tmp[j];
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }
}