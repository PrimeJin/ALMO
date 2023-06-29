import java.util.*;

class Solution {
    public int solution(int[] menu, int[] order, int k) {
        int answer = Integer.MIN_VALUE;
        
        int[] time = new int[1000001]; //제조현황
       
        
        int pt = 0;
        for(int i=0; i<order.length; i++){
            //i : 주문번호
            for(int j=i*k; j<=pt+menu[order[i]]; j++){
                time[j]++; //j시간에는 i손님의 제품을 제조중 
                if(j != i*k && j%k == 0) time[j]--;
            }
            if(pt < i*k) pt = i*k;
            
            pt += menu[order[i]];
        }
   
        for(int i=0; i<=pt; i++){ 
            answer = Math.max(answer, time[i]);
        }

        
        return answer;
    }
}