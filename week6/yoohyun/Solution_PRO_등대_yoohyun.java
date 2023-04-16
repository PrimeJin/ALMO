import java.util.*;
class Solution {
    static LinkedList<Integer>[] light;
    static int result = 0;
    public int solution(int n, int[][] lighthouse) {
        light = new LinkedList[n + 1];
        for(int i = 1; i <= n; i++){
           light[i] = new LinkedList<>();
        }
        
        for(int i = 0; i < lighthouse.length; i++){
            light[lighthouse[i][0]].add(lighthouse[i][1]);
            light[lighthouse[i][1]].add(lighthouse[i][0]);
        }
        
        dfs(1,0);
        
        
        return result;
    }
    public static int dfs(int cur, int before){
        //leaf 노드
        if(light[cur].get(0) == before && light[cur].size() == 1) return 1;
        
        int tmp = 0;
        for(int i = 0; i < light[cur].size(); i++){
            if(light[cur].get(i) == before) continue;
            tmp += dfs(light[cur].get(i), cur);
        }
        
        if(tmp >= 1) {
            result++;
            return 0;
        } 
        
        return 1;
        
    }
}
