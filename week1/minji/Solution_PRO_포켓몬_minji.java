package week1.minji;
import java.util.*;

public class Solution_PRO_포켓몬_minji {

    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int numsLength = nums.length;

        for(int i = 0; i < numsLength; i++){
            map.put(nums[i],1);
        }

        int length = map.size();

        if(length > numsLength/2){
            answer = numsLength/2;
        }else{
            answer = length;
        }

        return answer;
    }
}
