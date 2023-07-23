package DataStructures;

import java.util.*;

class BJ_2910 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Num> data = new HashMap<>();

        int index = 0;
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if (!data.containsKey(tmp)) {
                index++;
                data.put(tmp, new Num(1, index));
            } else {
                data.put(tmp, new Num(data.get(tmp).cnt + 1, data.get(tmp).index));
            }
        }


        ArrayList<Pair> cpData = new ArrayList<>();
        for (Map.Entry<Integer, Num> integerIntegerEntry : data.entrySet()) {
            cpData.add(new Pair(integerIntegerEntry.getKey(), integerIntegerEntry.getValue().index, integerIntegerEntry.getValue().cnt));
        }
        Collections.sort(cpData);

        for (Pair cpDatum : cpData) {
            for (int i = 0; i < cpDatum.z; i++) {
                System.out.print(cpDatum.x + " ");
            }
        }
    }

    static class Num {
        public int cnt;

        public int index;

        public Num(int cnt, int index) {
            this.cnt = cnt;
            this.index = index;
        }


    }

    static class Pair implements Comparable<Pair> {
        public int x;// number
        public int y;// index;
        public int z;// cnt;

        public Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Pair o) {
            if (o.z == this.z) {
                return this.y - o.y;
            }
            return o.z - this.z;
        }
    }
}