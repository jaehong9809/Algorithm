package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PG_TravelRoute {
    static List<String> results=new ArrayList<>();
    static boolean[] visited;
    public String[] solution(String[][] tickets) {

        visited=new boolean[tickets.length];
        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(results);
        String[] answer = results.get(0).split(" ");
        return answer;
    }

    public static void dfs(String start, String route, String[][] tickets, int cnt){
        if(cnt==tickets.length){
            results.add(route);
            return;
        }

        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(start)){
                if(!visited[i]){
                    visited[i]=true;
                    dfs(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
                    visited[i]=false;
                }
            }

        }

    }
}
