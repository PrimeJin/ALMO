import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int size = sequence.length;

        int[] pers1 = new int[size];
        int[] pers2 = new int[size];

        //-1로 시작하는 펄스 수열
        int pers = -1;
        for(int i=0; i < size; i++){
            pers1[i] = sequence[i] * pers;
            pers *= -1;
        }
        //1로 시작하는 펄스 수열
        pers = 1;
        for(int i=0; i < size; i++){
            pers2[i] = sequence[i] * pers;
            pers *= -1;
        }

        long[] dp1 = new long[size+1];
        long[] dp2 = new long[size+1];

        for(int i=1; i <= size; i++){
            dp1[i] = Math.max(dp1[i-1] + pers1[i-1], pers1[i-1]);
            answer = Math.max(answer, dp1[i]);
            dp2[i] = Math.max(dp2[i-1] + pers2[i-1], pers2[i-1]);
            answer = Math.max(answer, dp2[i]);

        }

        return answer;
    }
}