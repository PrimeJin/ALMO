import java.util.*;
class Solution {
    public long solution(int n, int[] times) {  //n:사람수
        
        long answer = 0;
        int len = times.length;
        
        Arrays.sort(times);
        long lt = 0;
        long rt = (long)times[len-1] * n;  //최악의 경우(걸리는 시간)
        
        while(lt<=rt) {
            long mid = (lt+rt)/2;
            long sum = 0;  //심사 처리한 사람 수
            for(int i=0; i<len; i++) {
                sum += mid/times[i];
            }
            if(sum >= n) {  //mid 동안 처리한 사람수가 같거나 더 많은 경우
                rt = mid-1;  //왼쪽 절반으로 범위 축소
                answer = mid;
            } else {
                lt = mid+1;
            } 
        }
        
        
        return answer;
    }
}