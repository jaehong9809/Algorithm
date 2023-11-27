package ToDo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class problem1 {
   /* public static void main(String[] args) {
        String[] friends={"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(solution(friends, gifts));

    }*/
    static public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Friends> map = new HashMap<>();
        Map<String, Integer> mostTakePresentFriend = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], new Friends());
            mostTakePresentFriend.put(friends[i], 0);
        }

        for (int i = 0; i < gifts.length; i++) {
            String[] s = gifts[i].split(" ");
            String from=s[0];
            String to=s[1];
            map.get(from).giveList.add(to);
            map.get(to).takeList.add(from);
        }


        for (String s : map.keySet()) {
            int tmp=0;
            int size = map.get(s).giveList.size()-map.get(s).takeList.size();
            map.get(s).presentPoint=size;
        }

        for (int i = 0; i < friends.length-1; i++) {
            for (int j = i+1; j < friends.length; j++) {
                String fromFriend=friends[i];
                String toFriend=friends[j];
                int fromSum=0;
                int toSum=0;

                for (int k = 0; k < map.get(fromFriend).giveList.size(); k++) {
                    if (map.get(fromFriend).giveList.get(k).equals(toFriend)) {
                        fromSum++;
                    }
                }

                for (int k = 0; k < map.get(toFriend).giveList.size(); k++) {
                    if (map.get(toFriend).giveList.get(k).equals(fromFriend)) {
                        toSum++;
                    }
                }
                if(fromSum==toSum||(fromSum==0&&toSum==0)){
                    if(map.get(fromFriend).presentPoint>map.get(toFriend).presentPoint){
                        mostTakePresentFriend.put(fromFriend, mostTakePresentFriend.get(fromFriend)+1);
                    }else if(map.get(toFriend).presentPoint>map.get(fromFriend).presentPoint){
                        mostTakePresentFriend.put(toFriend, mostTakePresentFriend.get(toFriend)+1);
                    }
                }else{
                    if(fromSum>toSum){
                        mostTakePresentFriend.put(fromFriend, mostTakePresentFriend.get(fromFriend)+1);
                    }
                    if(fromSum<toSum){
                        mostTakePresentFriend.put(toFriend, mostTakePresentFriend.get(toFriend)+1);
                    }
                }

            }
        }
        int max=0;
        for (String s : map.keySet()) {
            if(max<mostTakePresentFriend.get(s)){
                max=mostTakePresentFriend.get(s);
            }
        }
        answer=max;

        return answer;
    }



    static class Friends{
        List<String> giveList;
        List<String> takeList;
        Integer presentPoint;
        public Friends() {
            this.giveList = new ArrayList<>();
            this.takeList=new ArrayList<>();
            presentPoint=0;
        }

    }
}