package Implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class NDB_8 {
    static String s;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s= sc.nextLine();
        ArrayList<Character> arrayList = new ArrayList<>();
        int sum=0;
        for (int i = 0; i < s.length(); i++) {
            int tmp=s.charAt(i)-'0';
            if(tmp<10){
                sum+=tmp;
            }else{
                arrayList.add(s.charAt(i));
            }
        }
        Collections.sort(arrayList);
        s = "";
        for (int i = 0; i < arrayList.size(); i++) {
            s+=Character.toString(arrayList.get(i));
        }
        s += Integer.toString(sum);
        System.out.println(s);
    }
}