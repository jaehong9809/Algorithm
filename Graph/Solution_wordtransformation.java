package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution_wordtransformation {
    public int solution(String begin, String target, String[] words) {

        Queue<String> queue = new LinkedList<>();

        queue.offer(begin);

        Map<String, Integer> map = new HashMap<>();
        map.put(begin, 0);

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], 0);
        }

        boolean[] visited = new boolean[words.length];

        while (!queue.isEmpty()) {
            String now = queue.poll();

            if (now.equals(target)) {
                break;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i]) {
                    int samealp = 0;
                    for (int j = 0; j < words[0].length(); j++) {
                        if (now.charAt(j) == words[i].charAt(j)) {
                            samealp++;
                        }
                    }

                    if (samealp == words[0].length() - 1) {
                        queue.offer(words[i]);
                        visited[i] = true;
                        map.put(words[i], map.get(now) + 1);
                    }
                }
            }

        }

        if (!map.containsKey(target)) {
            return 0;
        }
        int answer = map.get(target);
        return answer;
    }

}