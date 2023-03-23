import java.util.*;
class Solution {
    public static int Ranswer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        char[] beginList = begin.toCharArray();
        int targetIdx = findTarget(target, words);
        if(targetIdx == -1) {
            return 0;
        }
        boolean[] visited = new boolean[words.length]; 
        dfs(words, 0, beginList, targetIdx, visited);
        if(Ranswer == Integer.MAX_VALUE) return 0;
        
        return Ranswer;
    }
    public void dfs(String[] words, int Tanswer, char[] begin, int targetIdx, boolean[] visited){
        for(int i = 0; i < words.length; i++){
            if(visited[i]) continue;
            int cnt = 0;
            for(int j = 0; j < begin.length; j++){
                if(begin[j] == words[i].charAt(j)) cnt++;
            }
            if(cnt == (begin.length - 1)){
                if(i == targetIdx){
                    Ranswer = Math.min(Ranswer, ++Tanswer);
                    return;
                }
                visited[i] = true;
                dfs(words, Tanswer + 1, words[i].toCharArray(), targetIdx, visited);
                visited[i] = false;
            }
        }
    }
    public int findTarget(String target, String[] words){
        for(int i = 0; i < words.length; i++){
            if(target.equals(words[i])) return i;
        }
        return -1;
    }
}
