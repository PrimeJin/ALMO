import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        int count = nums.length / 2;
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        if(count > set.size()){
            return set.size();
        }
        return count;
    }
}
