package Graph;

class PG_graph1 {
    static int[] data={1, 1, 1, 1, 1};
    static int target=3;
    static int cnt=0;
    public static void main(String[] args) {
        dfs(0, 0);
        System.out.println(cnt);


    }
    static void dfs(int a, int sum){
        if(a==data.length){
            if(sum==target){
                cnt++;

            }
        }
        else{
            dfs(a+1, sum+data[a]);
            dfs(a+1, sum-data[a]);

        }
    }
}