package String;

import java.util.Scanner;

class BJ_2941_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();

        while(true){
            if(str.contains("c=")){
                str=str.replace("c=", "a");
            }
            else if(str.contains("c-")){
                str=str.replace("c-", "a");
            }
            else if(str.contains("dz=")){
                str=str.replace("dz=", "a");
            }
            else if(str.contains("d-")){
                str=str.replace("d-", "a");
            }
            else if(str.contains("lj")){
                str=str.replace("lj", "a");
            }
            else if(str.contains("nj")){
                str=str.replace("nj", "a");
            }
            else if(str.contains("s=")){
                str=str.replace("s=", "a");
            }
            else if(str.contains("z=")){
                str=str.replace("z=", "a");
            }
            else{
                break;
            }
        }
        System.out.println(str.length());
    }
}