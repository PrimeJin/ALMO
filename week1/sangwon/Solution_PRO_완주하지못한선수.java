/*
    완주자 명단에 있는 사람은 index를 하나 빼주는 식으로 계산할 수 있다는걸 배웠다
*/

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> partMap = new HashMap<String, Integer>();
        
        // key : value = 참여자 이름 : 참가자는 1
        for(String partName : participant){
            partMap.put(partName, partMap.getOrDefault(partName, 0) +1);
        }
        
        // key : value = 완주자 이름 : 완주자는 -1해서 0이 되게
        for(String compName : completion){
            partMap.put(compName, partMap.getOrDefault(compName, 0) -1);
        }
        
        // 완주 못한 사람만 value 값이 혼자 1
        for(String key : partMap.keySet()) {
            if(partMap.get(key) == 1) answer = key;
        }
        
        return answer;
    }
}