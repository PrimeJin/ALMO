import java.util.*;
class Solution {
    public int solution(int[] ability, int number) {
        int answer = 0;
        int size = ability.length;
        for(int i=0; i<number; i++) {
            Arrays.sort(ability);
            int tmp = ability[0];
            ability[0] += ability[1];
            ability[1] += tmp;
        }
        
        for(int i=0; i<size; i++) {
            answer += ability[i];
        }
        return answer;
    }
}