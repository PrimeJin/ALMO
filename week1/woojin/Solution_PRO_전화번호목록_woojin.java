import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();
        
        //set에 전화번호 넣기
        for(String x : phone_book) {
            set.add(x);
        }

        //뽑은 전화번호의 부분문자열과 똑같은 번호가 set에 있다면 answer에 false넣고 return
        for(String x : phone_book) {
            for(int j=1; j<x.length(); j++) {
                if(set.contains(x.substring(0, j))) {
                    answer = false;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}