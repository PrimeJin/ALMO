import java.util.*;

class Solution {
    class Node {
        int data;
        int depth;
        
        public Node(int data, int depth){
            this.data = data;
            this.depth = depth;
        }
    }
    
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        LinkedList<Integer>[] adjList = new LinkedList[n+1];

        
        for(int i=0; i<n+1; i++) adjList[i] = new LinkedList<Integer>();
        
        for(int i=0; i<roads.length; i++){
            adjList[roads[i][0]].add(roads[i][1]);
            adjList[roads[i][1]].add(roads[i][0]);
        }
        
        int[] dist = new int[n+1]; //destination에서 정점 i까지의 최단거리를 메모이제이션하는 배열
        Arrays.fill(dist, -1);
        //source 각 원소별로 BFS 수행

        Queue<Node> q = new LinkedList<>();
        dist[destination] = 0;
        q.add(new Node(destination, 0)); //시작점           

        //destination에서 각 node로 뻗어나가기
        while(!q.isEmpty()){
            Node node = q.poll();

            for(int adj : adjList[node.data]){
                if(dist[adj] == -1){ 
                    q.add(new Node(adj, node.depth+1));
                    dist[adj] = dist[node.data] + 1;
                }
            }
        }    

        for(int i=0; i<sources.length; i++){
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
}