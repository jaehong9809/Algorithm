import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//1946
class Main{
    static class Grade implements Comparable<Grade>{
        public int x;
        public int y;

        public Grade(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Grade o) {
            return this.x-o.x;
        }
    }
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t=Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < t; test_case++) {

            ArrayList<Grade> arrayList = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                int a, b;
                String s = br.readLine();
                StringTokenizer st=new StringTokenizer(s);
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                arrayList.add(new Grade(a, b));
            }
            Collections.sort(arrayList);


        }
    }
}