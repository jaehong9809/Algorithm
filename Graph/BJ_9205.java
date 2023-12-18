package Graph;

import java.util.*;

/*
        고려사항
        출발 : 상근이네
        도착 : 락페스티벌
        맥주 한박스 20개
        50미터에 한병식
        50미터를 가려면 맥주 한병 마셔야함

        맥주를 더 구매해야 할 수 있음
        맥주 파는 편의점 있음
        빈병을 버리고 새맥주 병삼
        박스의 20병을 넘을 수 없음
        편의점을 나가도 50미터를 가기전 맥주 한병 마셔야함

        편의점, 상근이네, 락페스티벌 좌표 주어짐

        도착할 수 있는지 없는지 구하기 yes or no

        입력 test t
        편의점 개수  n
        x y
        루트 x^2 + y^2
     */
class BJ_9205 {
    static int[] visited;
    static boolean sign=false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for (int TESTCase = 0; TESTCase < t; TESTCase++) {
            sign=false;
            List<Pair> nodes = new ArrayList<>();
            int n=sc.nextInt();
            visited = new int[n + 2];
            for (int i = 0; i < n+2; i++) {
                int a=sc.nextInt();
                int b=sc.nextInt();
                nodes.add(new Pair(a, b));
            }
            int[][] matrix=new int[n+2][n+2];
            for (int i = 0; i < n+2; i++) {
                for (int j = 0; j < n+2; j++) {
                    int gapx=Math.abs(nodes.get(i).x - nodes.get(j).x);
                    int gapy=Math.abs(nodes.get(i).y - nodes.get(j).y);
                    int gap = gapx+gapy;
                    matrix[i][j]=gap;
                   //System.out.print(matrix[i][j]+" ");
                }
              // System.out.println();
            }
            // index 0은 집, n+1은 락
            boolean bfs = bfs(matrix, n);
            if(bfs){
                System.out.println("happy");
            }else{
                System.out.println("sad");
            }
        }

    }

    private static void dfs(int[][] matrix, int n, int now){
        visited[now]=1;
       // System.out.println(now);
       // System.out.println(matrix[now][n+1]);
        if(matrix[now][n+1]<=1000){
            sign=true;
        }

        for (int i = 0; i < n+2; i++) {
            if(now==i)continue;
            if(matrix[now][i]<=1000&&visited[i]==0){
                dfs(matrix, n, i);
            }
        }
    }

    private static boolean bfs(int[][] matrix, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] visited = new boolean[n + 2];
        visited[0]=true;
        int beer=1000;
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            //System.out.println(matrix[now][n+1]);
            if(beer>=matrix[now][n+1]){
                return true;
            }
            for (int i = 0; i < n+2; i++) {
                if(now==i)continue;
                if(beer>=matrix[now][i]&&!visited[i]){
                    visited[i]=true;
                    queue.offer(i);
                }
            }
        }
        return false;
    }

    static class Pair{
        public int x;
        public int y;
        public Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}