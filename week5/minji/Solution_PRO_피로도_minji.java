import java.util.*;

class Solution {
    int answer = Integer.MIN_VALUE;

    public int solution(int k, int[][] dungeons) {

        boolean[] visited = new boolean[dungeons.length];

        dfs(k,dungeons,0,visited);

        return answer;
    }

    public void dfs(int k, int[][] dungeons, int count, boolean[] visited){
        if(count == dungeons.length){
            answer = Math.max(count,answer);
            return;
        }

        for(int i=0; i<dungeons.length;i++){
            if(visited[i] || k < dungeons[i][0]) continue;

            visited[i] = true;
            dfs(k-dungeons[i][1],dungeons,count+1,visited);
            visited[i] = false;
        }
        answer = Math.max(count,answer);
    }
}