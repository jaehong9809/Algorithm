package DynamicProgramming;

class Solution_gotoschool {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n + 1][m + 1];

        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][1]][puddles[i][0]] = -1;
        }

        

        map[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                if (map[i][j] == -1) {
                    continue;
                }
                int a = 0;
                int b = 0;
                if (i - 1 >= 1 && map[i - 1][j] != -1) {
                    a = map[i - 1][j]% 1_000_000_007;
                }
                if (j - 1 >= 1 && map[i][j - 1] != -1) {
                    b = map[i][j - 1]% 1_000_000_007;
                }
                map[i][j] = (a + b) % 1_000_000_007;
            }
        }

        int answer = map[n][m];
        return answer;
    }
}