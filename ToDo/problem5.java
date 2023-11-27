package ToDo;

class problem5 {
    public static void main(String[] args) {
        int[] tops = {1, 1,0, 1};
        int n=2;
        System.out.println(solution(4, tops));
    }
    static public int solution(int n, int[] tops) {
        int answer = 0;
        int[] dp=new int[n+1];
        if(tops[0]==1){
            dp[1]=4;
        }else{
            dp[1]=3;
        }


        for (int i = 2; i <=n ; i++) {
            if(tops[i-1]==0){
                dp[i]=(dp[i-1]*2+(i*3-1))%10007;
            }
            else{
                dp[i]=(dp[i-1]*3+(i*3-1))%10007;
            }
        }
        answer=dp[n];
        return answer;
    }
}