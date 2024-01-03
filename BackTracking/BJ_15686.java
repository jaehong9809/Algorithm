package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class BJ_15686 {
    static int n;
    static int m;
    static int[][] matrix;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickenRes = new ArrayList<>();
    static boolean[] visited;
    static int[] arr;
    static int chickenDist=10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix=new int[n][n];
        arr=new int[m];
        visited=new boolean[14];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j]=Integer.parseInt(s[j]);
                if(matrix[i][j]==1){
                    houses.add(new int[]{i, j});
                }
                if(matrix[i][j]==2){
                    chickenRes.add(new int[]{i, j});
                }
            }
        }
        dfs(0, 0);
        System.out.println(chickenDist);
    }

    public static void dfs(int depth, int start){
        if(depth==m){
            int result=0;
            for (int[] house : houses) {
                int min=101;
                for (int i : arr) {
                    int dist = Math.abs(chickenRes.get(i)[0] - house[0]) + Math.abs(chickenRes.get(i)[1] - house[1]);
                    if(min>dist){
                        min=dist;
                    }
                }
                result+=min;
            }
            chickenDist=Math.min(result, chickenDist);
            return;
        }

        for (int i = start; i < chickenRes.size(); i++) {
            if(!visited[i]){
                visited[i]=true;
                arr[depth]=i;
                dfs(depth+1, i);
                visited[i]=false;
            }
        }
    }
}