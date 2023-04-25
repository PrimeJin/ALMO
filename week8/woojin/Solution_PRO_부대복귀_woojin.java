import java.util.*;
class Solution {
    static boolean[] check;
    static int[] distance;
    static List<List<Integer>> connectList;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] result = new int[sources.length];  //결과 담을 배열
        
        connectList = new ArrayList<>();
        for(int i=0; i<n+1; i++) {
            connectList.add(new ArrayList<>());
        }
        
        for(int i=0; i<roads.length; i++) {
            int from = roads[i][0];
            int to = roads[i][1];
            connectList.get(from).add(to);
            connectList.get(to).add(from);
        }
        
        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        bfs(destination);  //목적지부터 역으로 출발
        
        for(int i=0; i<sources.length; i++) {
            result[i] = distance[sources[i]]<Integer.MAX_VALUE ? distance[sources[i]] : -1;  //도착할 수 없으면 -1로 저장
        }
        
        return result;
    }
    
    public void bfs(int destination) {  //다익스트라
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(destination);
        distance[destination] = 0;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            for(int i=0; i<connectList.get(cur).size(); i++) {
                int next = connectList.get(cur).get(i);
                if(distance[next] > distance[cur] + 1) {
                    distance[next] = distance[cur] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}