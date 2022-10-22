package Implementation;

class BJ_4673 {
    static int graph[]=new int[10001];
    public static void main(String[] args) {
        for (int i = 1; i <=10000 ; i++) {
            String str=Integer.toString(i);
            int a=i;
            for (int j = 0; j < str.length(); j++) {
                a+=str.charAt(j)-'0';
            }
            if(a>10000)continue;
            graph[a]=1;
        }
        for (int i = 1; i <=10000 ; i++) {
            if(graph[i]==0) System.out.println(i);
        }
    }
}