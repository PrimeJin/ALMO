import java.util.*;
class Solution {
    public long solution(int n, int[] times) {  //n:사람수
        
        long answer = 0;
        int len = times.length;
        
        Arrays.sort(times);
        int lt = 0;
        int rt = times[len-1] * n;
        
        while(lt<rt) {
            int mid = (lt+rt)/2;
            int sum = 0;
            for(int i=0; i<len; i++) {
                sum += mid/times[i];
            }
            if(sum > n) {
                rt = mid-1;
                answer = mid;
            } else {
                lt = mid+1;
            } 
        }
        
        
        return answer;
    }
}