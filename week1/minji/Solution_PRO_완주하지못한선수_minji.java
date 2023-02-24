package week1.minji;

import java.util.*;
public class Solution_PRO_완주하지못한선수_minji {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();
        for(String name: completion){
            map.put(name,map.getOrDefault(name,0)+1);
        }

        for(String name: participant){
            if(map.size() == 0){
                answer = name;
            }
            if(!map.containsKey(name)){
                answer = name;
                break;
            }
            map.replace(name,map.get(name)-1);
            if(map.get(name).equals(0)) map.remove(name);
        }

        return answer;
    }

}
