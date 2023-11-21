package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class BJ_14562 {
    static int s;
    static int t;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int CASE=sc.nextInt();
        for (int TESTCASE = 0; TESTCASE < CASE; TESTCASE++) {
            s=sc.nextInt();
            t=sc.nextInt();
            dfs(s, t, 0);
            System.out.println(Collections.min(list));
            list.clear();
        }
    }

    public static void dfs(int me, int you, int cnt){
        if(me>you)return;
        if(me==you){
            list.add(cnt);
            return;
        }

        dfs(me*2, you+3, cnt+1);
        dfs(me+1, you, cnt+1);

    }
}