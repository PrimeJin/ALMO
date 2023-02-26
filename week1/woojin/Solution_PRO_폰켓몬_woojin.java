import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;  //최대값
        int size = nums.length;  //배열 길이 (포켓몬 마리수)
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums) {
            map.put(x, map.getOrDefault(x, 0) +1);
        }
        
        if(map.size() >= size/2) {
            answer = size/2;
        } else {
            answer = map.size();
        }
        
        return answer;
    }
}