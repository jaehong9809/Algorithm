package Graph;

import java.util.LinkedList;
import java.util.Queue;

class GameMap {

    static public int solution(int[][] maps) {
        int answer = 0;
        int n=maps.length;
        int m=maps[0].length;
        int[][] visited=new int[n][m];

        Queue<Node> queue=new LinkedList<>();
        queue.offer(new Node(0, 0));
        int[] dx={-1, 1, 0, 0};
        int[] dy={0, 0, -1, 1};
        visited[0][0]=1;
        while(!queue.isEmpty()){
            Node now=queue.poll();
            for(int i=0; i<4; i++){
                int newx=dx[i]+now.x;
                int newy=dy[i]+now.y;
                if(!(newx>=0&&newx<n&&newy>=0&&newy<m)){
                    continue;
                }
                if(maps[newx][newy]==1&&visited[newx][newy]==0){
                    queue.offer(new Node(newx, newy));
                    maps[newx][newy]=maps[now.x][now.y]+1;
                }
            }
        }

        if(maps[n-1][m-1]==1)return -1;
        return maps[n-1][m-1];
    }
    static class Node {
        int x;
        int y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}