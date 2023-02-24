/*
    옷의 종류를 key, 종류별 옷의 가짓수를 value로 저장하는 HashMap을 생각해본다
    조합의 수 = (종류별 옷의 가짓수 + 1)끼리의 곱의 합 - 1
    종류별 옷의 가짓수 + 1은 안 입은 경우의 수도 포함한 것이고
    조합의 수에서 1을 뺀 이유는 아무것도 안 입은 경우의 수를 제외한 것
*/

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> clothMap = new HashMap<String, Integer>();
        
        // 종류 : 종류별 옷의 가짓수
        for(String[] cloth : clothes){
            clothMap.put(cloth[1], clothMap.getOrDefault(cloth[1], 0) + 1);
        }
        
        int total = 1;
        for(String key : clothMap.keySet()){
            total *= (clothMap.get(key) +1);
        }
        
        answer = total - 1;
    
        return answer;
    }
}