package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class CorrectParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(solution(input));

    }
    static boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);
            if (word == '(') {
                stack.push(word);
            }
            else{
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop != '(') {
                    return false;
                }
            }
        }
        if(!stack.isEmpty())return false;

        return answer;
    }
}