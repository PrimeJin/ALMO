import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<int[]> originPq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        for(int[] job : jobs){
            originPq.add(job);
        }

        int nowTime = 0;
        int sum = 0;
        PriorityQueue<int[]> tmpPq = new PriorityQueue<>((a,b)->(a[1]-b[1]));

        while(!originPq.isEmpty() || !tmpPq.isEmpty()){
            while(!originPq.isEmpty() && originPq.peek()[0] <= nowTime){
                tmpPq.add(originPq.poll());
            }

            if(!tmpPq.isEmpty()){
                int[] nowJob = tmpPq.poll();
                nowTime += nowJob[1];
                sum += nowTime - nowJob[0];
            }else{
                nowTime = originPq.peek()[0];
            }
        }

        answer = (int) Math.floor(sum/jobs.length);
        return answer;
    }
}