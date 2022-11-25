package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class BJ_11652 {

    /*
    long 크기 =  8바이트 = 64 비트 2^64
    long 범위  =  -2^63~ ~ 2^63-1
    int 크기 = 4바이트 = 32비트 2^32
    int 범위 = -2^31 ~ 2^31-1

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        int max=0;
        long result=0;
        for (int i = 0; i < n; i++) {
            long tmp = Long.parseLong(br.readLine());
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            if(max<map.get(tmp)){
                max=map.get(tmp);
                result=tmp;
            }else if (max==map.get(tmp)){
                result = Math.min(result, tmp);
            }
        }
        System.out.println(result);
    }
}