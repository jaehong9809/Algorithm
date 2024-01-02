package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class BJ_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);


        double results=0;
        double sum=0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject=st.nextToken();
            double score=Double.parseDouble(st.nextToken());
            String level = st.nextToken();
            if (level.equals("P")) continue;
            sum+=score;
            results+=map.get(level)*score;
        }
        double result=(double) (Math.round((results/sum)*1000000))/1000000;
        long round = Math.round(result);
        System.out.println(result);
        //System.out.printf("%.6f\n", (results/sum));
    }
}