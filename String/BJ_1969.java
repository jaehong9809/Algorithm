package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

class BJ_1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strings.add(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        int result=0;
        for (int i = 0; i < m; i++) {
            Map<Character, Integer> map = new TreeMap<>();
            map.put('A', 0);
            map.put('T', 0);
            map.put('G', 0);
            map.put('C', 0);
            for (int j = 0; j < n; j++) {
                if(strings.get(j).charAt(i)=='A') map.put('A', map.get('A')+1);
                if(strings.get(j).charAt(i)=='T') map.put('T', map.get('T')+1);
                if(strings.get(j).charAt(i)=='G') map.put('G', map.get('G')+1);
                if(strings.get(j).charAt(i)=='C') map.put('C', map.get('C')+1);
            }
            int max=-1;
            char a=' ';
            for (Character character : map.keySet()) {
                if(max<map.get(character)){
                    max=map.get(character);
                    a=character;
                }
            }
            result+=n-max;
            System.out.print(a);
        }
        System.out.println();
        System.out.println(result);
    }
}