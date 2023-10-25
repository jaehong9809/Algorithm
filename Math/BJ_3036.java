package Math;

import java.util.Scanner;

class BJ_3036 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rings = new int[n];
        for (int i = 0; i < n; i++) {
            rings[i] = sc.nextInt();
        }
        int firstRing=rings[0];
        for (int i = 1; i < n; i++) {
            int gcd = gcd(firstRing, rings[i]);
            System.out.println(firstRing/gcd+"/"+rings[i]/gcd);
        }
    }

    public static int gcd(int a, int b) {
        int max=0;
        for (int i = 1; i <= a && i <= b; i++) {
            if(a%i==0&&b%i==0){
                max=i;
            }
        }
        return max;
    }
}