package ToDo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

class BJ_3190 {
    static int n;
    static int appleNum;
    static int[][] matrix;
    static LinkedList<Pair> directs = new LinkedList<>();
    static int directsNum;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        appleNum = Integer.parseInt(br.readLine());
        matrix = new int[n + 1][n + 1];
        matrix[1][1] = 1;
        for (int i = 0; i < appleNum; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrix[a][b] = 2;
        }
        directsNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < directsNum; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            String b = st.nextToken();
            directs.add(new Pair(a, b));
        }
        int direct = 0;
        int time = 0;
        int headX = 1;
        int headY = 1;
        int tailX = 1;
        int tailY = 1;
        while (true) {
            System.out.println(time);
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            time++;

            System.out.println(direct);
            if (direct == 0) {
                if (check(headX, headY, direct)) {
                    System.out.println("오른쪽으로 가다가");
                    break;
                }
                if(expandOrNot(headX + 1, headY, tailX, tailY)){
                    headX++;
                }else{
                    headX++;
                    tailX++;
                }

            }
            if (direct == 1) {
                if (check(headX, headY, direct)) {
                    System.out.println("왼쪽으로 가다가");
                    break;
                }
                if(expandOrNot(headX - 1, headY, tailX, tailY)){
                    headX--;
                }else{
                    headX--;
                    tailX--;
                }
            }
            if (direct == 2) {
                if (check(headX, headY, direct)) {
                    System.out.println("위으로 가다가");
                    break;
                }
                if(expandOrNot(headX, headY -1, tailX, tailY)){
                    headY--;
                }else{
                    headY--;
                    tailY--;
                }
            }
            if (direct == 3) {
                if (check(headX, headY, direct)) {
                    System.out.println("아래로 가다가");
                    break;
                }
                if(expandOrNot(headX, headY +1, tailX, tailY)){
                    headY++;
                }else{
                    headY++;
                    tailY++;
                }
            }
            if (!directs.isEmpty() && time == directs.get(0).time) {
                System.out.println("여길들어오나?");
                switch (direct){
                    case 0:
                        if (directs.get(0).direct.equals("D")) {
                            direct = 3;
                        }
                        if (directs.get(0).direct.equals("L")) {
                            direct = 2;
                        }
                        break;
                    case 1:
                        if (directs.get(0).direct.equals("D")) {
                            direct = 2;
                        }
                        if (directs.get(0).direct.equals("L")) {
                            direct = 3;
                        }
                        break;
                    case 2:
                        if (directs.get(0).direct.equals("D")) {
                            direct = 0;
                        }
                        if (directs.get(0).direct.equals("L")) {
                            direct = 1;
                        }
                        break;
                    case 3:
                        if (directs.get(0).direct.equals("D")) {
                            direct = 1;
                        }
                        if (directs.get(0).direct.equals("L")) {
                            direct = 0;
                        }
                        break;
                    default:break;
                }
                directs.remove(0);
            }
        }
    }

    private static boolean expandOrNot(int headx, int heady, int tailX, int tailY) {
        if (matrix[heady][headx] == 2) {
            matrix[heady][headx] = 1;
            return true;
        } else {
            matrix[heady][headx] = 1;
            matrix[tailY][tailX] = 0;
            return false;
        }
    }

    private static boolean check(int x, int y, int direct) {
        int dx[] = {1, -1, 0, 0}; //오, 왼 , 위, 아래
        int dy[] = {0, 0, -1, 1};
        int newx = x + dx[direct];
        int newy = y + dy[direct];
        if (newx >= 1 && newx <= n && newy >= 1 && newy <= n) {
            if (matrix[newy][newx] != 1) {
                return false;
            }
        }
        return true;
    }

    static class Pair {
        int time;
        String direct;

        public Pair(int time, String direct) {
            this.time = time;
            this.direct = direct;
        }
    }
}