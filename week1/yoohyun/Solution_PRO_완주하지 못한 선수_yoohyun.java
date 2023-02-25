import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map1 = new HashMap<>();
        for(String person: participant){
            map1.put(person, map1.getOrDefault(person, 0) + 1);
        }
        
        HashMap<String, Integer> map2 = new HashMap<>();
        for(String person: completion){
            map1.put(person, map1.get(person) - 1);
        }

        StringBuilder sb = new StringBuilder();
        for(String key : map1.keySet()){
            if(map1.get(key) > 0) {
                sb.append(key);
                break;
            }
        }  
        return sb.toString();
    }
}
