package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class BJ_5107 {
    static boolean rightSign = false;
    static Map<String, Boolean> visited = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TESTCASE = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            Map<String, String> map = new HashMap<>();
            visited.clear();

            for (int i = 0; i < n; i++) {
                String[] tmp = br.readLine().split(" ");
                visited.put(tmp[0], false);
                visited.put(tmp[1], false);
                map.put(tmp[0], tmp[1]);
            }

            int result = 0;

            for (String s : map.keySet()) {
                rightSign = false;
                if (visited.get(s).equals(false)) {
                    dfs(map, map.get(s), s);
                    visited.put(s, true);
                    if (rightSign) {
                        result++;
                    }
                }
            }

            System.out.println(TESTCASE + " " + result);
            TESTCASE++;
        }
    }
    public static void dfs(Map<String, String> map, String nowName, String startName) {
        if (startName.equals(nowName)) {
            rightSign = true;
            return;
        }
        if (map.containsKey(nowName)) {
            visited.put(nowName, true);
            dfs(map, map.get(nowName), startName);
        }
    }
}