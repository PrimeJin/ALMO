import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] menu, int[] order, int k) {
        int answer = 1;
        int[] guest = new int[order.length];
        guest[0] = menu[order[0]];
        int time = 1;

        for(int i=1; i<order.length; i++){
            if(guest[i-1] < time*k){
                guest[i] = (time*k) + menu[order[i]];
            }else{
                guest[i] = guest[i-1] + menu[order[i]];
            }

            time++;
        }

        time = 0;

        int[] totalTime = new int[guest[order.length-1]];
        for(int i=0; i<order.length; i++){
            for(int j=(time*k); j<guest[i];j++){
                totalTime[j]++;
            }
            time++;
        }

        Arrays.sort(totalTime);
        answer = totalTime[guest[order.length-1]-1];

        return answer;
    }
}