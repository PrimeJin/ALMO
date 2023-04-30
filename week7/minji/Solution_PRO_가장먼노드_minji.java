import java.util.*;

class Solution {
    public class Node{
        int number;
        LinkedList<Integer> list;

        public Node(int number){
            this.number = number;
            this.list = new LinkedList<>();
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Node[] nodeList = new Node[n+1];

        for(int i=1; i<=n;i++){
            nodeList[i] = new Node(i);
        }

        for(int i=0; i<edge.length;i++){
            nodeList[edge[i][0]].list.add(edge[i][1]);
            nodeList[edge[i][1]].list.add(edge[i][0]);
        }

        Queue<Node> q = new LinkedList<>();
        q.add(nodeList[1]);
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        int count=1;

        while(!q.isEmpty()){
            Node nowNode = q.poll();
            //System.out.println(nowNode.number + " " + count + " " + length);
            count--;

            for(int i=0;i<nowNode.list.size();i++){
                if(visited[nowNode.list.get(i)]) continue;
                visited[nowNode.list.get(i)] = true;
                q.add(nodeList[nowNode.list.get(i)]);
            }

            if(count == 0 && !q.isEmpty()){
                count += q.size();
                answer = q.size();
            }
        }
        return answer;
    }
}