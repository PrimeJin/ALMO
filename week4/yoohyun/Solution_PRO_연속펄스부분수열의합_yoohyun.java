import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int size = sequence.length;
        int[] tmp1 = new int[size + 1];
        int[] tmp2 = new int[size + 1];
        
        int c = -1;
        for(int i = 1; i <= size; i++){
            tmp1[i] = sequence[i - 1] * c;
            tmp2[i] = tmp1[i] * -1;
            c *= -1;
        }
        
        long[] dp1 = new long[size + 1];
        long[] dp2 = new long[size + 1];
        for(int i = 1; i <= size; i++){
            dp1[i] = Math.max(tmp1[i], tmp1[i] + dp1[i - 1]);        
            answer = Math.max(answer, dp1[i]);
            dp2[i] = Math.max(tmp2[i], tmp2[i] + dp2[i - 1]);
            answer = Math.max(answer, dp2[i]);
        }
        
        return answer;
    }   
}
