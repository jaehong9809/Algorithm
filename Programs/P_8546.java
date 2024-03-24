package Programs;

import java.util.Scanner;

class P_8546 {
    static int[][] data;
    static int[] arr=new int[2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        data=new int[n][4];

        for (int i = 0; i < n; i++) {
            data[i][0]=sc.nextInt();
            data[i][1]=sc.nextInt();
            data[i][2]=sc.nextInt();
            data[i][3]=sc.nextInt();
        }
        double max=-1;
        int a=0;
        int b=0;
        for (int i = 0; i <n-1 ; i++) {
            for (int j = i+1; j <n ; j++) {
                double res=calculateIoU(
                        data[i][0],
                        data[i][1],
                        data[i][2],
                        data[i][3],
                        data[j][0],
                        data[j][1],
                        data[j][2],
                        data[j][3]
                        );
                if(max<res){
                    max=res;
                    a=i;
                    b=j;
                }
            }
        }
        System.out.println((a+1)+" "+(b+1));

    }
    

    public static double calculateIoU(int ax, int ay, int aw, int ah, int bx, int by, int bw, int bh) {
        // 두 사각형의 좌측 상단 점과 우측 하단 점 좌표 계산
        int ax1 = ax;
        int ay1 = ay;
        int ax2 = ax + aw;
        int ay2 = ay + ah;

        int bx1 = bx;
        int by1 = by;
        int bx2 = bx + bw;
        int by2 = by + bh;

        // 교집합 영역 계산
        int intersectionArea = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1)) *
                Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));

        // 합집합 영역 계산
        int unionArea = aw * ah + bw * bh - intersectionArea;

        // IoU 계산
        double iou = (double) intersectionArea / unionArea;

        return iou;
    }
}