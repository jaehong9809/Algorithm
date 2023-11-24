package Implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class KAKAOTECHINTERSHIP2022_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] surveys={"AN", "CF", "MJ", "RT", "NA"};
        int[] choices={5, 3, 2, 7, 5};
        String[] surveys2={"TR", "RT", "TR"};
        int[] choices2={7, 1, 3};
        System.out.println(solution(surveys, choices));
        System.out.println(solution(surveys2, choices2));
    }
    static public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        for (int i = 0; i < survey.length; i++) {
            if(choices[i]==1){
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0))+3);
            }
            if(choices[i]==2){
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0))+2);
            }if(choices[i]==3){
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0))+1);
            }if(choices[i]==5){
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1))+1);
            }if(choices[i]==6){
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1))+2);
            }if(choices[i]==7){
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1))+3);
            }
        }
        String answer="";
        //System.out.printf("R = %d, T = %d\n",map.get('R'), map.get('T') );
        if(map.get('R')>=map.get('T')){
            answer+="R";
        }else{
            answer+="T";
        }
        //System.out.printf("C = %d, F = %d\n",map.get('C'), map.get('F') );
        if(map.get('C')>=map.get('F')){
            answer+="C";
        }else{
            answer+="F";
        }
        //System.out.printf("J = %d, M = %d\n",map.get('J'), map.get('M') );

        if(map.get('J')>=map.get('M')){
            answer+="J";
        }else{
            answer+="M";
        }
        //System.out.printf("A = %d, N = %d\n",map.get('A'), map.get('N') );

        if(map.get('A')>=map.get('N')){
            answer+="A";
        }else{
            answer+="N";
        }
        return answer;
    }
}