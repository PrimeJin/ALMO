import java.util.*;

class Solution {
    public int solution(int[] ability, int number) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<ability.length; i++){
            pq.add(ability[i]);
        }
        
        for(int i=0; i<number; i++){
            int n1 = pq.poll();
            int n2 = pq.poll();
            
            pq.add(n1 + n2);
            pq.add(n1 + n2); 
        }
        
        for(int i : pq){
            answer += i;
        }
        
        return answer;
    }
}