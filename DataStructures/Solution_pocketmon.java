package DataStructures;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution_pocketmon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] data={3, 3, 3, 2, 2, 2};
        System.out.println(solution(data));
    }
    static public int solution(int[] nums) {
        int answer = 0;
        Integer[] a = new Integer[nums.length];
        for (int i = 0; i < a.length; i++) {
            a[i]=nums[i];
        }
        Set<Integer> set = new HashSet<>(Arrays.asList(a));

        int len = set.size();
        if(len>=nums.length/2){
            answer= nums.length/2;
        }else{
            answer = len;
        }
        return answer;
    }
}