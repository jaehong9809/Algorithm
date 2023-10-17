package Implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LeastRectangle {
    public int solution(int[][] sizes) {
        int answer = 0;
        List<Integer> x=new ArrayList<>();
        List<Integer> y=new ArrayList<>();

        for(int i=0; i< sizes.length; i++){
            int max=Math.max(sizes[i][1], sizes[i][0]);
            int min=Math.min(sizes[i][1], sizes[i][0]);
            x.add(max);
            y.add(min);
        }

        return Collections.max(x)*Collections.max(y);
    }
}