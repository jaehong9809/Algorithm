package Programs;// don't place package name.

import java.util.Scanner;

// don't change 'Program' class name and without 'public' accessor.
class P_8690 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        int[][] data=new int[n][2];

        for(int i=0; i<n; i++){
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
        }


        for(int i=1; i<n; i++){
            int x = data[i][1] - data[i-1][1];
            int y = data[i][0] - data[i-1][0];

            if(x==0){
                if(y>0){
                    System.out.println(1+" "+y);
                }else{
                    System.out.println(3+" "+(y*(-1)));
                }

            }else{
                if(x>0){
                    System.out.println(2+" "+x);
                }else{
                    System.out.println(4+" "+(x*(-1)));
                }
            }
        }
    }
}