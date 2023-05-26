import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        //요청시간 오름차순으로 정렬
        Arrays.sort(jobs, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        //우선순위 큐는 소요시간이 적은 순으로 정렬 
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        int cnt = 0;
        int end = 0; //작업이 끝나는 시간
        int idx = 0;
        
        //모든 작업을 다 처리할 때까지 반복
        while(cnt < jobs.length){
            //현재 진행중인 작업시간 동안 요청이 들어왔으면 작업 큐에 삽입
            while(idx < jobs.length && jobs[idx][0] <= end){
                q.add(jobs[idx++]);
            }
            
            //큐가 비어있으면 가장 요청시간이 빠른 작업부터 시작
            if(q.isEmpty()){
                end = jobs[idx][0];
            } 
            //큐에 작업들이 남아있으면 수행시간이 짧은 순부터 처리
            else {
                int[] temp = q.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                cnt++; //작업을 처리했으니 카운트
            }
        }
    
        answer /= jobs.length;
        
        return answer;
    }
}