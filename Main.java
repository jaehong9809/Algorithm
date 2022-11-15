import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            data.add(sc.nextInt());
        }
        Collections.sort(data, Collections.reverseOrder());
        int cnt=0;
        int last=k;
        while(k!=0){
            last=k;
            for (int i = 0; i < n; i++) {
                if(k%data.get(i)==0){
                    k-=data.get(i);
                    cnt++;
                    break;
                }
            }
            if(last==k){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(cnt);
    }
}