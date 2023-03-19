import java.util.*;
class Solution {
    static boolean[] check;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        check = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!check[i]) {
                answer++;
                bfs(i, n, computers);
            }
        }
        
        return answer;

    }
    
    public void bfs(int num, int n, int[][] computers) {
        check[num] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(num);
        
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int i=0; i<n; i++) {
                if(cur != i && computers[cur][i] == 1 && !check[i]) {
                    queue.offer(i);
                    check[i] = true;
                }
            }
        }
    }
}