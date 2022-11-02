package Graph;

import java.util.*;

class BJ_18405 {
    static int n, k;
    static int s, x, y;
    static int matrix[][];
    static ArrayList<valueAndQueue> ary = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = scanner.nextInt();
                if (tmp != 0) {
                    Queue<Pair> q = new LinkedList<>();
                    q.offer(new Pair(i, j));
                    ary.add(new valueAndQueue(tmp, q));
                }
                matrix[i][j] = tmp;
            }
        }

        Collections.sort(ary);

        s = scanner.nextInt();
        x = scanner.nextInt();
        y = scanner.nextInt();

        bfs();

        System.out.println(matrix[x - 1][y - 1]);
    }

    public static void bfs() {
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        for (int seconds = 0; seconds < s; seconds++) {
            for (int i = 0; i < ary.size(); i++) {
                int qSize = ary.get(i).queue.size();

                for (int qCnt = 0; qCnt < qSize; qCnt++) {
                    Pair pair = ary.get(i).queue.poll();
                    for (int j = 0; j < 4; j++) {
                        int newx = pair.x + dx[j];
                        int newy = pair.y + dy[j];
                        if (newx >= 0 && newx < n && newy >= 0 && newy < n) {
                            if (matrix[newx][newy] == 0) {
                                matrix[newx][newy] = ary.get(i).value;
                                ary.get(i).queue.offer(new Pair(newx, newy));
                            }
                        }
                    }
                }
            }
          /*  for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();*/
        }

    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class valueAndQueue implements Comparable<valueAndQueue> {
        int value;
        public Queue<Pair> queue = new LinkedList<>();

        public valueAndQueue(int value, Queue<Pair> queue) {
            this.value = value;
            this.queue = queue;
        }

        @Override
        public int compareTo(valueAndQueue o) {
            return this.value - o.value;
        }
    }
}