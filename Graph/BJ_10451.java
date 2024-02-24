package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

class BJ_10451 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TESTCASE = Integer.parseInt(br.readLine());

        for (int TEST_CASE = 0; TEST_CASE < TESTCASE; TEST_CASE++) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] data = new int[n];
            boolean[] visited = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                data[i] = Integer.parseInt(s[i]);
            }
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 1; i <= n; i++) {
                graph.get(i).add(data[i - 1]);
            }
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(data[i-1], visited, graph);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    public static boolean[] dfs(int start, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
        Stack<Integer> st = new Stack<>();
        st.push(start);
        visited[start] = true;

        while (!st.isEmpty()) {
            Integer now = st.pop();

            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                if (!visited[next]) {
                    st.push(next);
                    visited[next] = true;
                } else {
                    if (start == next) {
                        return visited;
                    }
                }
            }
        }
        return visited;
    }

}