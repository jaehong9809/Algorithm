package Math;

import java.util.ArrayList;
import java.util.Scanner;

class BJ_11382 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Long> data = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            data.add(sc.nextLong());
        }
        long result=0;
        for (Long integer : data) {
            result+=integer;
        }
        System.out.println(result);
    }
}