import java.util.ArrayList;
import java.util.Scanner;

class Main{
    static int n;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();

        for (int i = 0; i < n; i++) {
            int tmp= sc.nextInt();
            arrayList.add(tmp);
        }

    }
}