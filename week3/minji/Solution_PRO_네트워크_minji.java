import java.util.*;

class Solution {

    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(visited[i]) continue;

            visited = bfs(n, computers, visited, i);
            answer++;
        }

        return answer;
    }

    public boolean[] bfs(int n, int[][] computers, boolean[] visited, int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int i=0; i < n; i++){
                if(visited[i] || computers[now][i] == 0) continue;

                queue.add(i);
                visited[i] = true;
            }
        }

        return visited;
    }
}