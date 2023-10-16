package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class HateSameNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }

        System.out.println(Arrays.toString(solution(arr)));
    }
    static public int[] solution(int []arr) {
        Stack<Integer> st = new Stack();
        st.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (st.peek() != arr[i]) {
                st.push(arr[i]);
            }
        }

        int[] answer = new int[st.size()];
        int cnt=0;

        for (Integer integer : st) {
            answer[cnt]=integer;
            cnt++;
        }

        return answer;
    }
}