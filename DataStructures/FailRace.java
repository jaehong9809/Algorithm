package DataStructures;

import java.util.HashMap;
import java.util.Map;

class FailRace {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"a", "b", "c", "a"}, new String[]{"a", "b", "c"}));
    }

    static public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0)+1);
        }

        for (String s : completion) {
            map.put(s, map.get(s)-1);
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            System.out.println(stringIntegerEntry.getKey()+" "+stringIntegerEntry.getValue());
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if(stringIntegerEntry.getValue()==1)answer=stringIntegerEntry.getKey();
        }
        return answer;
    }
}