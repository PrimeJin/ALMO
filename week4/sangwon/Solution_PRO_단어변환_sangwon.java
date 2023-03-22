import java.util.*;

class Solution {

    class Node {
        String word;
        int idx;
        int depth;

        public Node(String word, int idx, int depth){
            this.word = word;   //words 배열의 문자열
            this.idx = idx;     //words에서의 index
            this.depth = depth; //변환 단계 수
        }
    }

    int answer = 0;
    int count = 0; //변환 단계 카운트
    public void bfs(String st, String target, String[] words, boolean[] visited){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(st, words.length, 0)); //begin이 맨처음 들어갈 예정

        while(!q.isEmpty()){
            Node n = q.poll();
            visited[n.idx] = true; //계속 전체 배열을 순회하기 때문에 방문처리 필수
            count++;

            //모든 문자열을 순회하는데 동시에 최소단계가 나올 수도 있으니까
            //그 중에 정답이 있는지를 체크하고 있으면 cnt+1한채로 리턴
            //TC: "aoa", "aof", ["aob", "aoc", "aof", "aog"], answer = 1
            //TC: "aoa", "bob", ["aob", "aoc", "bob", "aog"], answer = 2            
            for(int i=0; i<words.length; i++){
                if(!visited[i] && compareStr(words[i], n.word) == 1){
                    q.add(new Node(words[i], i, count));

                    if(words[i].equals(target)) {
                        answer = n.depth + 1;
                        return;
                    }
                }
            }
        }
    }

    //문자열 다른 갯수 비교
    public int compareStr(String a, String b){
        int len = a.length();
        int cnt = 0;
        for(int i=0; i<len; i++){
            if(a.charAt(i) != b.charAt(i)) cnt++;
        }
        return cnt;
    }

    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length+1]; //맨처음 begin도 큐에 넣고 싶어서 +1

        //변환할 수 없는 경우 먼저 체크
        boolean check = false;
        for(String word : words) {
            if(word.equals(target)) {
                check = true;
                break;
            }
        }
        if(!check) return 0;

        bfs(begin, target, words, visited);
        return answer;
    }
}