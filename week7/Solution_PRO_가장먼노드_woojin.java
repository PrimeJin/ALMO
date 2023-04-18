import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[][] connect = new boolean[n+1][n+1];
        boolean[] check = new boolean[n+1];
        
        for(int i=0; i<edge.length; i++) {  //간선 양방향 설정
            for(int j=0; j<2; j++) {
                // int start = edge[i][0];
                // int end = edge[i][1];
                connect[edge[i][0]][edge[i][1]] = true;
                connect[edge[i][1]][edge[i][0]] = true;
            }
        }
        
        answer = bfs(1, n, connect, check);
        return answer;
    }
    
    public int bfs(int num, int n, boolean[][] connect, boolean[] check) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(num);
        check[num] = true;
        
        int cnt = 0;
        while(!queue.isEmpty()) {
            cnt = queue.size();  //현재 queue에 들어가있는 개수
            for(int i=0; i<cnt; i++) {  //cnt대신 queue.size()쓰면 queue 사이즈가 점점 줄어들어서 안됨
                int cur = queue.poll();
                for(int j=1; j<=n; j++) {
                    if(!check[j] && connect[cur][j]) {
                        check[j] = true;
                        queue.offer(j);
                    }
                }
            }
        }
        return cnt;  //마지막 queue에 들어있떤 개수 (가장 먼 노드 개수)
    }
}