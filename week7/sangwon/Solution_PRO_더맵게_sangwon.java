/*
    스코빌 지수가 낮은 순으로 정렬한 후
    가장 작은 것 2개씩 꺼내서 새로 만들고 다시 PQ에 넣는다
*/

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i : scoville){
            q.add(i);
        }
        
        int cnt = 0;
        //제일 낮은 스코빌 지수가 K 미만인 경우 계속 반복
        while(q.peek() < K){
            if(q.size() < 2) return -1;
            int a = q.poll();
            int b = q.poll();
            
            if(a==0 && b==0) return -1;
            
            q.add(a + b*2);
            cnt++;
        }
        
        return cnt;
    }
}