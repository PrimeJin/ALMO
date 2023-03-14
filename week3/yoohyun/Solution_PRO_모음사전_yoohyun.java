import java.util.*;
class Solution {
    public int solution(String word) {
        int answer = 0;
        char[] alp = {'A', 'E', 'I', 'O', 'U'};
        int[] input = {781, 156, 31, 6, 1};
        
        for(int i = 0; i < word.length(); i++){
            for(int j = 0; j < alp.length; j++){
                if(word.charAt(i) == alp[j]){
                    answer += input[i] * j + 1;
                }   
            }
        }
        
        return answer;
    }
}
