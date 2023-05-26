import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int size = jobs.length;

        Arrays.sort(jobs, (o1, o2) -> o1[0]==o2[0]?o1[1]-o2[1] : o1[0]-o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int endPoint = jobs[0][0];
        int idx = 1;
        int sum = 0;
        pq.offer(jobs[0]);
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            
            endPoint += tmp[1];
            sum += endPoint - tmp[0];
            
            while(idx < size && jobs[idx][0] <= endPoint) {
                pq.offer(jobs[idx]);
                idx++;
            }
            
            if(idx < size && pq.isEmpty()) {
                endPoint = jobs[idx][0];
                pq.offer(jobs[idx]);
                idx++;
            }
        }
        
        answer = sum / size;
        return answer;
    }
}