import java.util.*;

class Solution {
    int[] distanceArr;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = {};

        LinkedList<Integer>[] loadMap = new LinkedList[n+1];
        for(int i=1; i<n+1;i++){
            loadMap[i] = new LinkedList<>();
        }

        for(int i=0;i < roads.length; i++){
            loadMap[roads[i][0]].add(roads[i][1]);
            loadMap[roads[i][1]].add(roads[i][0]);
        }

        answer = new int[sources.length];

        distanceArr= new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(destination);
        boolean[] visited= new boolean[n+1];
        visited[destination] = true;

        bfs(queue,visited,loadMap);

        for(int i=0; i<sources.length; i++){
            if(sources[i] == destination){
                answer[i] = 0;
                continue;
            }else if(distanceArr[sources[i]] == 0){
                answer[i] =-1;
                continue;
            }

            answer[i] = distanceArr[sources[i]];
        }

        return answer;
    }

    public void bfs(Queue<Integer> queue, boolean[] visited, LinkedList<Integer>[] loadMap){
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i=0;i<loadMap[now].size();i++){
                if(visited[loadMap[now].get(i)]) continue;

                distanceArr[loadMap[now].get(i)] = distanceArr[now]+1;
                visited[loadMap[now].get(i)] = true;
                queue.add(loadMap[now].get(i));
            }
        }
    }
}