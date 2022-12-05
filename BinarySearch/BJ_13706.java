package BinarySearch;

import java.math.BigInteger;
import java.util.Scanner;

class BJ_13706 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n= sc.nextLine();
        BigInteger input=new BigInteger(n);

        binarySearch(input);

    }

    private static void binarySearch(BigInteger n) {
        BigInteger start=new BigInteger("1");
        BigInteger end=n;

        while (true){
            BigInteger mid=(start.add(end)).divide(new BigInteger("2"));
            int result=mid.multiply(mid).compareTo(n);
            if(result==0){
                System.out.println(mid);
                break;
            }else if(result==1){
                end=mid.subtract(new BigInteger("1"));
            }else{
                start=mid.add(new BigInteger("1"));
            }
        }
    }
}