import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        int button = 1;

        while(storey != 0){
            int remain = storey % (button*10);

            if(remain < 5*button || (remain == (5*button) && (storey % (button*100)) < 5*button*10)){
                answer += remain/button;
                storey = storey - remain;
            }
            else{
                answer += (button*10 - remain)/button;
                storey = storey + (button*10 - remain);
            }

            button *= 10;
        }

        return answer;
    }
}