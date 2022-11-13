package Implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SWEA_1983 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        for (int test_case = 1; test_case <= t; test_case++) {
            int n= sc.nextInt();
            int k= sc.nextInt();
            ArrayList<gradeAndIndex> grade = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                int total = a*35+b*45+c*20;
                grade.add(new gradeAndIndex(total, i+1));
            }
            int gap=n/10;
            Collections.sort(grade, new Comparator<gradeAndIndex>() {
                @Override
                public int compare(gradeAndIndex o1, gradeAndIndex o2) {
                    return o2.grade-o1.grade;
                }
            });
            int cnt=0;
            int now=1;
            System.out.print("#"+test_case+" ");
            for (int i = 0; i < n; i++) {
                if(cnt==gap){
                    cnt=0;
                    now++;
                }
                cnt++;

                if(grade.get(i).index==k){
                    if(now==1){
                        System.out.println("A+");
                    }
                    if(now==2){
                        System.out.println("A0");
                    }
                    if(now==3){
                        System.out.println("A-");
                    }
                    if(now==4){
                        System.out.println("B+");
                    }
                    if(now==5){
                        System.out.println("B0");
                    }
                    if(now==6){
                        System.out.println("B-");
                    }
                    if(now==7){
                        System.out.println("C+");
                    }
                    if(now==8){
                        System.out.println("C0");
                    }
                    if(now==9){
                        System.out.println("C-");
                    }
                    if(now==10){
                        System.out.println("D0");
                    }
                }

            }
        }
    }
    static class gradeAndIndex{
        int grade;
        int index;

        public gradeAndIndex(int grade, int index) {
            this.grade = grade;
            this.index = index;
        }
    }
}