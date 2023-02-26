import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(String[] strArr : clothes) {
            map.put(strArr[1], map.getOrDefault(strArr[1], 0) +1);
        }
        
        if(map.size() == 1) {
            for(String key : map.keySet()) {
                answer = map.get(key);
            }
        } else {  //경우의 수 (A+1) * (B+1) -1(아무것도 입지 않는 경우)
            int tempNum = 1;
            for(String key : map.keySet()) {
                tempNum *= (map.get(key)+1); 
            }
            
            answer += (tempNum - 1);
        }
            
        return answer;
    }
}