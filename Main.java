import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine();
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j <str.length()-i+1 ; j++) {
                set.add(str.substring(j, j+i));
            }
        }
        System.out.println(set.size());
    }
}