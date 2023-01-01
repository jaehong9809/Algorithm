package Sorting;

import java.util.ArrayList;
import java.util.Collections;

class PG_Sorting2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = {3, 30, 34, 5, 9};
        s.solution(input);
    }

    static class Solution {
        public String solution(int[] numbers) {
            String answer = "";
            ArrayList<Pair> data = new ArrayList<>();
            for (int i = 0; i < numbers.length; i++) {
                data.add(new Pair(numbers[i]));
            }

            Collections.sort(data);
            if(Integer.toString(data.get(0).x).charAt(0)=='0')
                return "0";
            for (Pair datum : data) {
                answer += Integer.toString(datum.x);
            }
            System.out.println(answer);
            return answer;
        }
    }

    static class Pair implements Comparable<Pair> {
        public int x;
        public int y;

        public Pair(int x) {
            this.x = x;
            this.y = Integer.toString(x).charAt(0) - '0';
        }

        @Override
        public int compareTo(Pair o) {
            /*if(o.y==this.y){
                int a=this.x;
                int b=o.x;
                while(a<1000){
                    a*=10;
                }
                while (b<1000){
                    b*=10;
                }
                if(b==a){
                    return Integer.toString(this.x).length() - Integer.toString(o.x).length();
                }
                return b-a;

            }
            return o.y-this.y;
        }*/
            String a = Integer.toString(o.x) + Integer.toString(this.x);
            String b = Integer.toString(this.x) + Integer.toString(o.x);

            return a.compareTo(b);
        }
    }
}