package geometry;

import java.util.Scanner;

class BJ_3009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] data=new int[3][2];
        int[] result=new int[2];
        for (int i = 0; i < 3; i++) {
            data[i][0]=sc.nextInt();
            data[i][1]=sc.nextInt();
        }

        if (data[0][1] == data[1][1]) {
            result[1]=data[2][1];
            if (data[0][0] == data[2][0]) {
                result[0]=data[1][0];
            }else{
                result[0]=data[0][0];
            }
        }
        if (data[0][1] == data[2][1]) {
            result[1]=data[1][1];
            if (data[0][0] == data[1][0]) {
                result[0]=data[2][0];
            }else{
                result[0]=data[0][0];
            }
        }
        if (data[2][1] == data[1][1]) {
            result[1]=data[0][1];
            if(data[2][0]==data[0][0]){
                result[0]=data[1][0];
            }else{
                result[0]=data[2][0];
            }
        }

        System.out.println(result[0]+" "+result[1]);

    }
}