package Implementation;

class SecretOfTwo {
    public static void main(String[] args){
        solution("aukks", "wbqd", 5);
    }
    static public String solution(String s, String skip, int index) {
        char[] results=new char[s.length()];

        for(int i=0; i<s.length(); i++){
            int now=(int)s.charAt(i);
            int cnt=0;
            while(cnt<=index){
                if(now>(int)'a'+25){
                    now=(int)'a';
                }
                if(!skip.contains(String.valueOf((char)now))){
                    cnt++;
                    results[i]=(char)now;
                }
                now++;
            }
        }
        String answer= new String(results);
        return answer;
    }
}