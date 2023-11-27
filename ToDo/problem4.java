package ToDo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class problem4 {
    public static void main(String[] args) {
        int coin=4;
        int[] cards={3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4};
        System.out.println(solution(coin, cards));
    }
    static public int solution(int coin, int[] cards) {
        int answer = 0;
        List<Integer> myCards = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        int target=cards.length+1;
        for (int i = 0; i < cards.length/3; i++) {
            myCards.add(cards[i]);
        }
        for (int i = cards.length/3; i < cards.length; i++) {
            queue.offer(cards[i]);
        }
        int round=0;
        while (!queue.isEmpty()) {
            round++;
            for (Integer myCard : myCards) {
                System.out.print(myCard+" ");
            }
            System.out.println();
            boolean canSubmit=false;
            int a=queue.poll();
            int b=queue.poll();
            if(a+b==target){
                if(coin>1){
                    coin-=2;
                    continue;
                }
            }
            int aMateIndex=-1;
            int bMateIndex=-1;
            for (int i = 0; i < myCards.size(); i++) {
                if(a+myCards.get(i)==target){
                    aMateIndex=i;
                }
                if(b+myCards.get(i)==target){
                    bMateIndex=i;
                }
            }
            if(aMateIndex>=0){
                if(coin>0){
                    myCards.remove(aMateIndex);
                    canSubmit=true;
                }
            }
            if(bMateIndex>=0){
                if(aMateIndex>=0){
                    if(coin>0){
                        myCards.add(b);
                    }
                }else{
                    if(coin>0){
                        myCards.remove(bMateIndex);
                        canSubmit=true;
                    }
                }
            }
            if(aMateIndex<0&&bMateIndex<0){
                int c=-1;
                int d=-1;
                for (int i = 0; i <myCards.size()-1 ; i++) {
                    for (int j = i+1; j < myCards.size(); j++) {
                        if(myCards.get(i)+myCards.get(j)==target){
                            c=i;
                            d=j;
                        }
                    }
                }
                if(c!=-1){
                    myCards.remove(d);
                    myCards.remove(c);
                    canSubmit=true;
                }
            }
            if(!canSubmit)break;
        }

        answer=round;
        return answer;
    }
}