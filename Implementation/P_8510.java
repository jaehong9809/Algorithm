package Implementation;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class P_8510 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int meter=sc.nextInt();
        int n=sc.nextInt();
        Map<String, String> map = new TreeMap<>();
        Map<String, Integer> res = new TreeMap<>();
        sc.nextLine();
        for (int i = 0; i <n*2 ; i++) {
            String[] s=sc.nextLine().split(" ");
            if (map.containsKey(s[0])) {
                int start_hour=Integer.parseInt(map.get(s[0]).substring(0, 2));
                int start_minute=Integer.parseInt(map.get(s[0]).substring(3, 5));
                int start_second=Integer.parseInt(map.get(s[0]).substring(6, 8));
                int end_hour=Integer.parseInt(s[1].substring(0, 2));
                int end_minute=Integer.parseInt(s[1].substring(3, 5));
                int end_second=Integer.parseInt(s[1].substring(6, 8));
                int resSec=end_second-start_second;
                if(resSec<0){
                    end_minute--;
                    resSec+=60;
                }
                int resMin=end_minute-start_minute;
                if(resMin<0){
                    end_hour--;
                    resMin+=60;
                }
                int resHour=end_hour-start_hour;
                double sum = (double) resHour+ (double) (resMin)/60.0 + ((double) (resSec)/60.0)/60.0;
                double cal=(double) meter / sum;
                res.put(s[0], (int) cal);
            }else{
                map.put(s[0], s[1]);
            }
        }

        for (String s : res.keySet()) {
            System.out.println(s+" "+res.get(s));
        }
    }
}