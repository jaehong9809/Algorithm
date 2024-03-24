package DataStructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class P_8541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] puzzle = {{1, 2}, {3, 0}};
        String str=sc.nextLine();
        int[][] input=new int[2][2];

        input[0][0]=str.charAt(0)-'0';
        input[0][1]=str.charAt(1)-'0';
        str=sc.nextLine();
        input[1][0]=str.charAt(0)-'0';
        input[1][1]=str.charAt(1)-'0';
        int indexcol=0;
        int indexrow=1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if(input[i][j]==40) {
                    input[i][j] = 0;
                    indexcol=i;
                    indexrow=j;
                }

            }
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("0001");
        queue.offer("0111");
        queue.offer("1110");
        queue.offer("1000");
        int cnt=0;
        boolean sign=false;
        while (true){
            String poll = queue.poll();
            queue.offer(poll);
            int acol=poll.charAt(0)-'0';
            int arow=poll.charAt(1)-'0';
            int bcol=poll.charAt(2)-'0';
            int brow=poll.charAt(3)-'0';

            if(acol==indexcol&& arow==indexrow){
                sign=true;
            }
            if(sign){
                cnt++;
                int tmp=input[acol][arow];
                input[acol][arow]=input[bcol][brow];
                input[bcol][brow]=tmp;


                boolean res = compareAandB(puzzle, input);
                if(res) {
                    if(cnt>6){
                        System.out.println(12-cnt);
                    }else{
                        System.out.println(cnt);
                    }
                    break;
                }
            }
            if(cnt>12){
                System.out.println(-1);
                break;
            }
        }

    }

    static boolean compareAandB(int[][] puzzle, int[][] input) {
        boolean sign = true;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (puzzle[i][j] != input[i][j]) {
                    sign = false;
                }
            }
        }
        return sign;
    }


}