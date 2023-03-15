import java.util.*;
import java.io.*;

class Solution {
    static int[] visited;
    
    public void dfs(int x, int n, int[][] computers) {
        if(visited[x] == 0) visited[x] = x;
        
        for(int i=0; i<n; i++) {
            if(visited[i] == 0 && computers[x][i] == 1 && x != i){
                visited[i] = x;
                dfs(i, n, computers);
            }
        }
        return;
    }
    
    public int solution(int n, int[][] computers) {
      int answer = 0;
      visited = new int[n]; //cnt를 넣으면서 int형으로 받을 이유가 없어졌다
       
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(visited[i] == 0) {
                cnt++;
                dfs(i, n, computers);
            }
        }
       
        answer = cnt; 
               
        return answer;
    }
}