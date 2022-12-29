package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class BJ_1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            set.add(Integer.valueOf(st.nextToken()));
        }
        int tmp;
        st=new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            tmp=Integer.parseInt(st.nextToken());
            if(set.contains(tmp)){
                set.remove(tmp);
            }
        }
        System.out.println(set.size());
        for (Integer integer : set) {
            System.out.print(integer+" ");
        }
    }
}