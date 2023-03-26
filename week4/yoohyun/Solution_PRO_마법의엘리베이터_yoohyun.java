import java.util.*;
class Solution {
    public static int Ranswer = Integer.MAX_VALUE; 
    public int solution(int storey) {
        int size = String.valueOf(storey).toCharArray().length;
        dfs(storey, 0);
        
        return Ranswer;
    }
    public void dfs(int storey, int Tanswer){
        if(storey < 10) {
            Ranswer = Math.min(Tanswer + storey % 10, Ranswer);
            Ranswer = Math.min(Tanswer + 10 - (storey % 10) + 1, Ranswer);
            return;
        }
        dfs((storey + 10 - (storey % 10)) / 10 , Tanswer + 10 - (storey % 10));
        dfs((storey - storey % 10) / 10, Tanswer + storey % 10);
    }
}
