/*
    가질 수 있는 포켓몬 종류의 최댓값을 따지는 문제이기 때문에
    중복되는 포켓몬 종류는 제거
    서로다른 포켓몬 종류가 N/2보다 크다면 N/2마리가 최댓값이고,
    아니면 포켓몬 종류를 세면 된다
*/

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        //중복을 없애기 위해 HashSet 사용
        HashSet<Integer> set = new HashSet<Integer>();
        int answer = 0;
                
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }       
        
        
        if(set.size() >= nums.length/2){ // 서로다른 포켓몬 종류가 N/2보다 크거나 같은 경우
            answer = nums.length/2; // N/2를 리턴
        } else { // 아니면 포켓몬 종류를 세서 리턴
            answer = set.size();
        }
        
        return answer;
    }
}