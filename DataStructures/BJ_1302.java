package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class BJ_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String , Integer> map=new HashMap<>();


        for (int i = 0; i < n; i++) {
            String tmp=br.readLine();
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
        }
        int max=0;
        String maxStr="";
        for (String s : map.keySet()) {
            if(max<map.get(s)){
                max=map.get(s);
                maxStr=s;
            }
            else if(max==map.get(s)){
                if(s.compareTo(maxStr)<0){
                    maxStr=s;
                }
            }
        }
        System.out.println(maxStr);
    }

}