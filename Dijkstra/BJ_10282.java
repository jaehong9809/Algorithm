package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BJ_10282 {
    static int INF = (int) 1e9;
    static int distance[];
    static ArrayList<ArrayList<Pair>> arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int TESTCASE = 0; TESTCASE < t; TESTCASE++) {
            int n, d, c;
            String str = br.readLine();
            st = new StringTokenizer(str);
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            arrayList = new ArrayList<>();
            distance = new int[n + 1];

            Arrays.fill(distance, INF);

            for (int i = 0; i <= n; i++) {
                arrayList.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                int a, b, s;

                str = br.readLine();

                st = new StringTokenizer(str);

                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());

                arrayList.get(b).add(new Pair(a, s));
            }
            dijkstra(c);
            int cnt=0;
            int max=0;
            for (int i = 1; i <=n ; i++) {
                if(distance[i]!=INF){
                    cnt++;
                    max= Math.max(max, distance[i]);
                }
            }
            System.out.println(cnt+" "+max);
        }


    }

    private static void dijkstra(int start) {
        PriorityQueue<Pair> pairPriorityQueue = new PriorityQueue<>();
        distance[start] = 0;
        pairPriorityQueue.offer(new Pair(start, 0));

        while (!pairPriorityQueue.isEmpty()) {

            Pair tmp = pairPriorityQueue.poll();
            int now = tmp.x;
            int dist = tmp.y;

            if (distance[now] < dist) continue;

            for (int i = 0; i < arrayList.get(now).size(); i++) {
                int cost = arrayList.get(now).get(i).y + distance[now];

                if (cost < distance[arrayList.get(now).get(i).x]) {
                    distance[arrayList.get(now).get(i).x] = cost;
                    pairPriorityQueue.offer(new Pair(arrayList.get(now).get(i).x, cost));
                }
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            return this.y-o.y;
        }
    }
}