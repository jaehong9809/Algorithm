import java.util.*;

class Pair{
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
class Main{
    public static int matrix[][];
    public static int n;
    public static ArrayList<Integer>arrayList=new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        n= sc.nextInt();
        matrix=new int[n+1][n+1];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str= sc.nextLine();
            for (int j = 0; j < str.length(); j++) {
                matrix[i][j]=str.charAt(j)-'0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==1){
                    bfs(i, j);

                }
            }
        }
        System.out.println(arrayList.size());
        Collections.sort(arrayList);
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
    }
    public static void bfs(int startx, int starty){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startx, starty));
        matrix[startx][starty]=0;
        int dx[]={-1, 1, 0, 0};
        int dy[]={0,0,-1,1};
        int v=1;
        while(!queue.isEmpty()){
            Pair now=queue.poll();
            int x= now.getX();
            int y=now.getY();
            for (int i = 0; i < 4; i++) {
                int newx=x+dx[i];
                int newy=y+dy[i];
                if(newx>=0&&newx<n&&newy>=0&&newy<n){
                    if(matrix[newx][newy]==1){
                        queue.offer(new Pair(newx, newy));
                        matrix[newx][newy]=0;
                        v++;
                    }
                }
            }
        }
        arrayList.add(v);
    }
}