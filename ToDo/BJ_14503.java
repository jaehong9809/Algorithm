package ToDo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BJ_14503 {
    /*
        matrix = new int[n][m];
        0 ~ n-1
        0 ~ m-1


        d = 0 북, = 1 동, = 2 남, = 3 서
     */
    static int n;
    static int m;
    static int startRow;
    static int startCol;
    static int d;

    static int[][] map;
    static int[][] cleaned;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        cleaned = new int[n][m];
        st = new StringTokenizer(br.readLine());
        startRow = Integer.parseInt(st.nextToken());
        startCol = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        int cnt=0;
        while (true) {
            if(map[startRow][startCol]==0&&cleaned[startRow][startCol]==0){
                System.out.println(startRow+" "+startCol+"check!!");
                cleaned[startRow][startCol]=1;
                cnt++;
            }
            for (int i = 0; i <n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(cleaned[i][j]);
                }
                System.out.println();
            }
            System.out.println(startRow +" "+ startCol);
            if(map[startRow][startCol]==1){
                break;
            }
            int[] result = checkDirect(startRow, startCol);
            for (int i : result) {
                System.out.print(i+" ");
            }
            System.out.println();
            boolean cleansign=false;
            int index=d;

            for (int i = 0; i < 4; i++) {
                if(result[i]==1){
                    cleansign=true;
                    break;
                }
            }
            if(cleansign){
                while (true){
                    index++;
                    if(index>=4){
                        index=0;
                    }
                    if(result[index]==1){
                        d=index;
                        break;
                    }
                }
                System.out.println(d);
                if(d==0){
                    startRow -=1;
                }
                if(d==1){
                    startCol +=1;
                }
                if (d==2){
                    startRow +=1;
                }
                if(d==3){
                    startCol -=1;
                }
            }else{
                if(d==0){
                    startRow +=1;

                }
                if(d==1){
                    startCol -=1;

                }
                if (d==2){
                    startRow -=1;

                }
                if(d==3){
                    startCol +=1;
                }
            }

        }
        System.out.println(cnt);
    }

    //동서남북
    public static int[] checkDirect(int row, int col) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[] result = new int[4];
        for (int i = 0; i < 4; i++) {
            int nextRow = dx[i] + row;
            int nextCol = dy[i] + col;
            if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m) {
                if (cleaned[nextRow][nextCol] == 0 && map[nextRow][nextCol] == 0) {
                    result[i] = 1;
                }
            }
        }
        return result;
    }
}