import java.util.*;
class Solution {
    static List<Integer> answerList;
    static int len;
    static boolean[] check;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        len = begin.length();

        boolean flag = false;
        for(int i=0; i<words.length; i++) {
            if(target.equals(words[i])) {
                flag = true;
                break;
            }
        }
        if(!flag) {
            return 0;
        }
        
        check = new boolean[words.length];
        answer = bfs(begin, target, words);
        
        return answer;
    }
    
    public int bfs(String begin, String target, String[] words) {
        Queue<String> queue = new ArrayDeque();
        // for(int i=0; i<words.length; i++) {
        //     int cnt = 0;
        //     for(int j=0; j<len; j++) {
        //         if(begin.charAt(j) == words[i].charAt(j)) {
        //             cnt++;
        //         }
        //     }
        //     if(cnt == len-1) {
        //         queue.offer(words[i]);        
        //         check[i] = true;
        //         break;
        //     }
        // }
        queue.offer(begin);
        
        int answerCnt = 0;
        while(!queue.isEmpty()) {
            String cur = queue.poll();
            if(cur.equals(target)) {
                return answerCnt;
            } else {
                for(int i=0; i<words.length; i++) {
                    int cnt = 0;
                    if(!check[i]) {
                        for(int j=0; j<len; j++) {
                            if(cur.charAt(j) == words[i].charAt(j)) {
                                cnt++;
                            }
                        }
                        // check[i] = true;
                    }
                    if(cnt == len-1) {
                        check[i] = true;
                        queue.offer(words[i]);
                        answerCnt++;
                    }
                }
            }
        }
        return answerCnt;
    }
}