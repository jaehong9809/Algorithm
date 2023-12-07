package ToDo;

import java.util.*;

class gabia_3 {
    public static void main(String[] args) {
        String[] req_id={"FFF","AAA", "CCC", "CCC", "DDD", "EEE"};
        int[][] req_info = {{1, 3, 15}, {0, 5, 20}, {0, 5, 20}, {0, 10, 30}, {1, 20, 20}, {1, 19, 10}};




        String[] solution = solution(req_id, req_info);
        for (String s : solution) {
            System.out.println(s);
        }
    }
    // 구매요청 0,  판매요청 1, 양, 가격
    static public String[] solution(String[] req_id, int[][] req_info) {
        List<ReqStat> reqStats = new ArrayList<>();
        Map<String, User> users = new TreeMap<>();
        for (int i = 0; i <req_id.length ; i++) {
            users.put(req_id[i], new User(0, 0));
        }
        for (int i = 0; i <req_info.length ; i++) {
            if(req_info[i][0]==0){
                reqStats.add(new ReqStat(req_id[i], "BUY", req_info[i][1], req_info[i][2]));
            }else{
                reqStats.add(new ReqStat(req_id[i], "SELL", req_info[i][1], req_info[i][2]));
            }
        }
        for (int i = 0; i < reqStats.size(); i++) {
            if(!reqStats.get(i).pending){
                continue;
            }
            if(reqStats.get(i).type.equals("SELL")){
                int max=-1;
                int index=-1;
                for (int j = 0; j < reqStats.size(); j++) {
                    if(i==j||!reqStats.get(j).pending){
                        continue;
                    }
                    if(reqStats.get(j).type.equals("BUY")&&reqStats.get(j).price>=reqStats.get(i).price){
                        if(max<reqStats.get(j).price){
                            index=j;
                            max=reqStats.get(j).price;
                        }
                    }
                }
                if(index!=-1){
                    int amount = Math.min(reqStats.get(i).amount, reqStats.get(index).amount);
                    reqStats.get(i).amount-=amount;
                    reqStats.get(index).amount-=amount;

                    users.get(reqStats.get(i).name).gold-=amount;
                    users.get(reqStats.get(i).name).silver+=(max*amount);
                    users.get(reqStats.get(index).name).gold+=amount;
                    users.get(reqStats.get(index).name).silver -= (max * amount);
                    if(reqStats.get(i).amount==0){
                        reqStats.get(i).pending=false;
                    }
                    if(reqStats.get(index).amount==0){
                        reqStats.get(index).pending=false;
                    }
                }

            }else{
                int min=101;
                int index=-1;
                for (int j = 0; j < reqStats.size(); j++) {
                    if(i==j||!reqStats.get(j).pending){
                        continue;
                    }
                    if(reqStats.get(j).type.equals("SELL")&&reqStats.get(j).price<=reqStats.get(i).price){
                        if(min>reqStats.get(j).price){
                            index=j;
                            min=reqStats.get(j).price;
                        }
                    }
                }
                if(index!=-1){
                    int amount = Math.min(reqStats.get(i).amount, reqStats.get(index).amount);
                    reqStats.get(i).amount-=amount;
                    reqStats.get(index).amount-=amount;

                    users.get(reqStats.get(i).name).gold+=amount;
                    users.get(reqStats.get(i).name).silver-=(min*amount);
                    users.get(reqStats.get(index).name).gold-=amount;
                    users.get(reqStats.get(index).name).silver += (min * amount);

                    if(reqStats.get(i).amount==0){
                        reqStats.get(i).pending=false;
                    }
                    if(reqStats.get(index).amount==0){
                        reqStats.get(index).pending=false;
                    }
                }
            }
        }
        String[] answer = new String[users.size()];
        int index=0;
        for (String s : users.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(s).append(" ");
            if(users.get(s).silver==0){
                sb.append("0 0");
            }else{
                if(users.get(s).gold>0){
                    sb.append("+");
                    sb.append(users.get(s).gold);
                    sb.append(" ");
                    sb.append(users.get(s).silver);
                }else{
                    sb.append(users.get(s).gold);
                    sb.append(" ");
                    sb.append("+");
                    sb.append(users.get(s).silver);
                }
            }
            answer[index]= String.valueOf(sb);
            index++;
        }
        return answer;
    }
    static class User{
        int silver;
        int gold;

        public User(int silver, int gold) {
            this.silver = silver;
            this.gold = gold;
        }
    }
    static class ReqStat{
        String name;
        String type;
        int amount;
        int price;
        boolean pending;

        public ReqStat(String name, String type, int amount, int price) {
            this.name=name;
            this.type = type;
            this.amount = amount;
            this.price = price;
            this.pending = true;
        }
    }
}