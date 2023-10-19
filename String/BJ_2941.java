package String;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BJ_2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<String> list = new ArrayList<>();
        list.add("c=");
        list.add("c-");
        list.add("dz=");
        list.add("d-");
        list.add("lj");
        list.add("nj");
        list.add("s=");
        list.add("z=");
        int cnt=0;
        int rest=0;
        int[] check=new int[str.length()];
        for (int i = 0; i < list.size(); i++) {
            String tmp=list.get(i);
            for(int j=0; j<str.length()-tmp.length()+1; j++){
                if(tmp.equals(str.substring(j, j+tmp.length()))){
                    if(i==2){
                        for(int k=j; k<j+tmp.length(); k++){
                            check[k]=1;
                        }
                    }
                    if(i==7){
                        if(check[j]==1){
                            continue;
                        }
                    }
                    cnt+=tmp.length();
                    rest++;
                }
            }
        }

        System.out.println(str.length()-cnt+rest);
    }
}