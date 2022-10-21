package Floyd_warshall;

import java.util.Scanner;

import static java.lang.Math.min;

class BJ_11404 {
    static int n, m;
    static final int INF= (int) 1e9;

    static int graph[][];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n= sc.nextInt();
        m= sc.nextInt();

        graph=new int[n+1][n+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(i==j)graph[i][j]=0;
                else{
                    graph[i][j]=INF;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int a, b, c;
            a= sc.nextInt();
            b= sc.nextInt();
            c= sc.nextInt();
            graph[a][b]=min(c, graph[a][b]);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n ; j++) {
                for (int k = 1; k <=n ; k++) {
                    graph[j][k]= min(graph[j][k], graph[j][i]+graph[i][k]);
                }
            }
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {

                if(graph[i][j]==INF){
                    System.out.print(0+" ");
                }
                else{
                    System.out.print(graph[i][j]+" ");
                }
            }
            System.out.println();
        }

    }

}