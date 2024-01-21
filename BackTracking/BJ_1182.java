package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BJ_1182 {
    static int cnt=0;
    static int n;
    static int m;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] data=new int[n];
        visited=new boolean[n];
        String[] s = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            data[i]=Integer.parseInt(s[i]);
        }
        for (int i = 1; i <=n ; i++) {
            int[] arr = new int[i];
            dfs(i, arr, 0, data, 0);
        }
        System.out.println(cnt);
    }
    public static void dfs(int depth, int[] arr, int now, int[] data, int start){
        if(depth==now){
            int sum=0;

            for (int i : arr) {
                sum+=data[i];
            }
            if(sum==m){
                cnt++;
            }
            return;
        }
        for (int i = start; i <n ; i++) {
            if(!visited[i]){
                visited[i]=true;
                arr[now]=i;
                dfs(depth, arr, now+1, data, i);
                visited[i]=false;
            }
        }
    }

}