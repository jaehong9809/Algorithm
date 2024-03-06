package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ_11536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i]=br.readLine();
        }
        String[] increas=names.clone();
        String[] decreas=names.clone();

        Arrays.sort(decreas, Comparator.reverseOrder());
        Arrays.sort(increas);
        boolean iSign=true;
        boolean dSign=true;

        for (int i = 0; i < n; i++) {
            if (!increas[i].equals(names[i])) {
                iSign=false;
            }
            if (!decreas[i].equals(names[i])) {
                dSign=false;
            }
        }

        if(iSign){
            System.out.println("INCREASING");
        }
        else if(dSign){
            System.out.println("DECREASING");
        }
        else{
            System.out.println("NEITHER");
        }
    }
}
