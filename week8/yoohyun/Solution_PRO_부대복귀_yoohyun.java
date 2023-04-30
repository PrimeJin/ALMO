import java.util.*;
class Solution {
    public static Node[] nodes;
    public static class Node implements Comparable<Node> {
        int vertex, weight;
        Node next;
        
        public Node(int vertex, int weight, Node next){
           this.vertex = vertex;
           this.weight = weight;
           this.next = next;
        }
        
        public Node(int vertex, int weight){
           this.vertex = vertex;
           this.weight = weight;
        }
        
        public int compareTo(Node node){
            return Integer.compare(this.weight, node.weight);
        }
    }
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        nodes = new Node[n + 1];
        
        for(int i = 0; i < roads.length; i++){
            int from = roads[i][0];
            int to = roads[i][1];
            nodes[from] = new Node(to, 1, nodes[from]);
            nodes[to] = new Node(from, 1, nodes[to]);
        }
        
        int[] minValue = new int[n + 1];
        int cnt = 0;
        Arrays.fill(minValue, Integer.MAX_VALUE);
        minValue[destination] = 0;
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(destination, minValue[destination]));
        
        while(!pq.isEmpty()){
            Node cur = pq.remove();
            if(visited[cur.vertex]) continue;
            visited[cur.vertex] = true;
            if(++cnt == n) break;
        
            for(Node tmp = nodes[cur.vertex]; tmp != null; tmp = tmp.next){
                if(!visited[tmp.vertex] && minValue[cur.vertex] + tmp.weight < minValue[tmp.vertex]){
                    minValue[tmp.vertex] = minValue[cur.vertex] + tmp.weight;
                    pq.offer(new Node(tmp.vertex, minValue[tmp.vertex]));        
                }
            }
            
        }
        for(int i = 0; i < sources.length; i++){
            answer[i] = (minValue[sources[i]] == Integer.MAX_VALUE) ? -1 : minValue[sources[i]];
        }
        
        return answer;
    }
}
