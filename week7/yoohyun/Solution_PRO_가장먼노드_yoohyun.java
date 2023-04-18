import java.util.*;
class Solution {
    static Node[] nodes;
    static int t;
    public static class Node implements Comparable<Node>{
        int vertex, weight;
        int time;
        Node next;
        public Node(int vertex, int weight, Node next){
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
        public Node(int vertex, int time){
            this.vertex = vertex;
            this.time = time;
        }
        public int compareTo(Node n){
            return Integer.compare(this.time, n.time);
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        nodes = new Node[n + 1];   
        
        for(int i = 0; i < edge.length; i++){
            int from = edge[i][0];
            int to = edge[i][1];
            nodes[from] = new Node(to, 1, nodes[from]);
            nodes[to] = new Node(from, 1, nodes[to]);
        }
        
        int[] minValue = new int[n + 1];
        boolean[] isVisited = new boolean[n + 1];
        Arrays.fill(minValue, Integer.MAX_VALUE);
        minValue[1] = 0;
        
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,t++));
        
        while(!pq.isEmpty()){
            Node node = pq.remove();
    
            if(isVisited[node.vertex]) continue;
            isVisited[node.vertex] = true;
            if(++cnt == n) break;
            
            for(Node tmp = nodes[node.vertex]; tmp != null; tmp = tmp.next){
                if(!isVisited[tmp.vertex] && minValue[node.vertex] + tmp.weight < minValue[tmp.vertex]){
                    minValue[tmp.vertex] = minValue[node.vertex] + tmp.weight;
                    max = Math.max(max, minValue[tmp.vertex]);
                    pq.add(new Node(tmp.vertex, t++));
                }
            }
            
        }
        
        for(int i = 2; i <= n; i++){
            if(max == minValue[i]) answer++;
        }
        
        return answer;
    }
}
