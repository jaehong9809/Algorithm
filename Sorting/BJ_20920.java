package Sorting;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class BJ_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] split = s.split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        Map<String, Word> data = new HashMap<>();
        for (int i = 0; i < n; i++){
            String tmp = br.readLine();
            if(tmp.length()<m){
                continue;
            }
            if (data.containsKey(tmp)) {
                data.get(tmp).cnt++;
            }else{
                data.put(tmp, new Word(tmp));
            }
        }
        ArrayList<Word> data2 = new ArrayList<>();
        for (String key: data.keySet()) {
            //System.out.println(data.get(key).cnt+" "+data.get(key).length+" "+data.get(key).word);
            data2.add(data.get(key));
        }
        Collections.sort(data2);
        for (Word word : data2) {

            bw.write(word.word+"\n");
        }
        bw.close();
    }
    static class Word implements Comparable<Word>{
        String word;
        int cnt;
        int length;
        public Word(String word){
            this.word=word;
            this.length=word.length();
            this.cnt=1;
        }
        @Override
        public int compareTo(Word o) {
            if(o.cnt==this.cnt){
                if (o.length == this.length) {
                    return this.word.compareTo(o.word);
                }
                return o.length-this.length;
            }

            return o.cnt-this.cnt;
        }
}

}
