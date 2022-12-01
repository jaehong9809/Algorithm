package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BJ_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int l= Integer.parseInt(st.nextToken());
        String str=br.readLine();
        String[] s = str.split(" ");
        int load[]=new int[1001];
        int max=0;
        for (String s1 : s) {
            load[Integer.parseInt(s1)]=1;
            if(max<Integer.parseInt(s1)){
                max=Integer.parseInt(s1);
            }
        }
        int result=0;
        for (int i = 1; i <= max; i++) {
            if (load[i]==1){
                result++;
                for (int j = 0; j < l; j++) {
                    if(i+j>1000){
                        break;
                    }
                    load[i+j]=0;
                }
            }
        }
        System.out.println(result);
    }
}