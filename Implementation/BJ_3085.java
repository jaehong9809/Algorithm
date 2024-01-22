package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BJ_3085 {
    static int n;
    static char[][] map;
    static int max=-1;
    static int[] dx=new int[]{0, 0, 1, -1};
    static int[] dy=new int[]{1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map=new char[n][n];
        for (int i = 0; i < n; i++) {
            String str=br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j]=str.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx=i+dx[k];
                    int ny=j+dy[k];
                    if(nx>=0&&nx<n&&ny>=0&&ny<n){
                        char tmp=map[i][j];
                        map[i][j]=map[nx][ny];
                        map[nx][ny]=tmp;
                        for (int q = 0; q < n; q++) {
                            for (int w = 0; w < n; w++) {
                                max=Math.max(findLN(q, w, map), max);
                            }
                        }
                        tmp=map[i][j];
                        map[i][j]=map[nx][ny];
                        map[nx][ny]=tmp;
                    }
                }
            }
        }
        System.out.println(max);
    }
    public static int findLN(int startx, int starty, char[][] map){
        int cntX=0;
        int cntY=0;
        for (int i = startx; i <n ; i++) {
            if(map[i][starty]==map[startx][starty]) {
                cntX++;
            }
            else break;
        }
        for (int i = startx; i >=0; i--) {
            if(map[i][starty]==map[startx][starty]) {
                cntX++;
            }
            else break;
        }
        for (int i = starty; i < n; i++) {
            if(map[startx][i]==map[startx][starty]) {
                cntY++;
            }
            else break;
        }
        for (int i = starty; i >=0; i--) {
            if(map[startx][i]==map[startx][starty]) {
                cntY++;
            }
            else break;
        }
        return Math.max(cntX-1, cntY-1);
    }
}