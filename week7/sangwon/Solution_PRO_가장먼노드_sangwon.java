import java.util.*;

class Solution {
    
    class Node {
        int idx; //정점의 인덱스
        int dis; //1번 정점으로부터 해당 정점까지의 거리
        
        public Node(int idx, int dis){
            this.idx = idx;
            this.dis = dis;
        }
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        //각 정점의 인접정점 리스트
        LinkedList<Integer>[] adjList = new LinkedList[n+1];
        for(int i=0; i<n+1; i++) adjList[i] = new LinkedList<Integer>();
        
        //각 정점의 방문여부 체크용 배열
        boolean[] visited = new boolean[n+1];
                
        //인접정점 리스트 입력값으로 채워넣기(그래프 구성)
        for(int i=0; i<edge.length; i++){
            adjList[edge[i][0]].add(edge[i][1]);
            adjList[edge[i][1]].add(edge[i][0]);
        }
        
        //BFS 순회를 위해 방문 순서대로 정점을 담는 큐
        Queue<Node> q = new LinkedList<>();
        
        //1번 정점으로부터 거리가 가장 먼 정점부터 내림차순으로 정렬한 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o2.dis - o1.dis;
        });
        
        //1번 정점에서 스타트
        q.add(new Node(1, 0));
        
        //시작점 방문처리
        visited[1] = true;
        
        //BFS 순회
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i : adjList[node.idx]){
                if(!visited[i]) {
                    visited[i] = true;
                    //실질적인 BFS 순회용
                    q.add(new Node(i, node.dis+1));
                    //1번 정점으로부터 방문한 정점까지의 거리를 기록하기 위함
                    pq.add(new Node(i, node.dis+1)); 
                }
            }
        }
        
        //가장 먼저 꺼내지는 정점 = 1번 정점으로부터 가장 멀리 있는 정점일 것
        Node fn = pq.peek();
        int maxDis = fn.dis; 
        int cnt = 0;
        //해당 거리와 같은 정점의 개수를 세면 된다
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.dis == maxDis) cnt++;
        }
        
        answer = cnt;
        
        return answer;
    }
}