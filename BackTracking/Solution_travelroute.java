package BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution_travelroute {
    static boolean[] visited;
    static String[][] tics;
    static List<String> res = new ArrayList<>();

    static public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        tics = tickets;
        dfs("ICN", 0, "ICN");
        Collections.sort(res);
        String[] answer = res.get(0).split(" ");
        return answer;
    }

    static void dfs(String start, int cnt, String route) {
        if (cnt == tics.length) {
            res.add(route);
            return;
        }

        for (int i = 0; i < tics.length; i++) {
            if (tics[i][0].equals(start)) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(tics[i][1], cnt + 1, route + " " + tics[i][1]);
                    visited[i] = false;
                }
            }
        }
    }
}