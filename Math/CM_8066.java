package Math;

import java.util.Scanner;

class CM_8066 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextInt();
        double y = sc.nextInt();
        double z = sc.nextInt();
        double res = ((x / 2) / y) * z;
        System.out.println((int)res);
    }
}