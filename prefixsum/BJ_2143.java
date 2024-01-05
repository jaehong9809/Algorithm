package prefixsum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class BJ_2143 {
    static long t;
    static int n;
    static int m;
    static int[] a;
    static long[] presumA;
    static int[] b;
    static long[] preSumB;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t=sc.nextLong();
        n=sc.nextInt();
        a=new int[n+1];
        presumA=new long[n+1];
        for (int i = 1; i <=n; i++) {
            a[i]=sc.nextInt();
        }
        m=sc.nextInt();
        b=new int[m+1];
        preSumB=new long[m+1];
        for (int i = 1; i <= m; i++) {
            b[i]=sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            presumA[i]=presumA[i-1]+a[i];
        }
        for (int i = 1; i <= m; i++) {
            preSumB[i]=preSumB[i-1]+b[i];
        }
        List<Long> sumACase = new ArrayList<>();
        List<Long> sumBCase = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                sumACase.add(presumA[j]-presumA[i-1]);
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                sumBCase.add(preSumB[j]-preSumB[i-1]);
            }
        }
        Collections.sort(sumACase);
        Collections.sort(sumBCase);
        long result=0;
        for (int i = 0; i < sumACase.size(); i++) {
            int lowerBound=lowerBound(sumBCase, t-sumACase.get(i));
            int upperBound=upperBound(sumBCase, t-sumACase.get(i));
            long cnt=upperBound-lowerBound;
            if(cnt>0)result+=cnt;
        }
        System.out.println(result);
    }

    private static int lowerBound(List<Long> list, Long target) {
        int start=0;
        int end=list.size();

        while (start<end){
            int mid=(start+end)/2;
            if(list.get(mid)>=target){
                end=mid;
            }else{
                start=mid+1;
            }
        }

        return end;
    }
    private static int upperBound(List<Long> list, Long target) {
        int start=0;
        int end=list.size();

        while (start<end){
            int mid=(start+end)/2;
            if(list.get(mid)>target){
                end=mid;
            }else{
                start=mid+1;
            }
        }

        return end;
    }


}