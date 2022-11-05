package Graph;

import java.util.ArrayList;
import java.util.Scanner;

class BJ_14888 {
    // 덧셈, 뺄셈, 곱셈, 나눗셈
    static int[] opers = new int[4];
    static ArrayList<Integer> numbers = new ArrayList<>();
    static int total;
    static int N;
    static int minResult = 1000000000;
    static int maxResult = -1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            numbers.add(sc.nextInt());
        }
        for (int i = 0; i < 4; i++) {
            int tmp = sc.nextInt();
            opers[i] = tmp;
        }
        total = numbers.get(0);
        dfs(1,total);
        System.out.println(maxResult);
        System.out.println(minResult);
    }

    private static void dfs(int index,int now) {
        if(index==N){
            if(minResult>now)minResult=now;
            if(maxResult<now)maxResult=now;
        }
        if (opers[0] > 0) {
            opers[0]--;
            dfs(index + 1, now+numbers.get(index));
            opers[0]++;
        }
        if (opers[1] > 0) {
            opers[1]--;
            dfs(index + 1,now-numbers.get(index));
            opers[1]++;
        }
        if (opers[2] > 0) {
            opers[2]--;
            dfs(index + 1,now*numbers.get(index));
            opers[2]++;
        }
        if (opers[3] > 0) {
            opers[3]--;
            dfs(index + 1,now/numbers.get(index));
            opers[3]++;
        }
    }
}