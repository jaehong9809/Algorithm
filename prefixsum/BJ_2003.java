package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BJ_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] s = bufferedReader.readLine().split(" ");
        int[] data=new int[n];
        int[] preSum=new int[n+1];
        for (int i = 0; i <n ; i++) {
            data[i] = Integer.parseInt(s[i]);
            preSum[i+1]=data[i]+preSum[i];
        }
        int cnt=0;
        for (int i = 1; i <n ; i++) {
            for (int j = i; j <=n ; j++) {
                int sum=preSum[j]-preSum[i-1];
                if(sum==m){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}