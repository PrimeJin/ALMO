import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        //참여자 선수명만큼 +1 처리
        for(String x : participant) {
            map.put(x, map.getOrDefault(x, 0) +1);
        }
        
        //완주자 선수명만큼 -1 처리
        for(String x : completion) {
            map.put(x, map.getOrDefault(x, 0) -1);
        }
        
        String answer = "";
        
        //map에서 남아있는 선수가 완주하지 못한 선수
        for(int i=0; i<map.size(); i++) {
            if(map.get(participant[i]) > 0) {
                answer = participant[i];
                break;
            }
        }
       
        return answer;
    }
    
}