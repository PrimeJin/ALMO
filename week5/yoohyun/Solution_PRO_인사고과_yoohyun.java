import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 0, max=0;
        int[] target = scores[0];
        Arrays.sort(scores,(a,b)->(a[0]!=b[0]?b[0]-a[0]:a[1]-b[1]));

        List<Integer> list = new ArrayList<>();

        for(int[] score :scores){

            if(score[1]<max){
                if(score.equals(target)){
                    return -1;
                }
            }else{
                list.add(score[0]+score[1]);
                max=Math.max(max,score[1]);
            }
        }
        
        Collections.sort(list,Collections.reverseOrder());
        answer = list.indexOf(target[0]+target[1])+1;
        
        return answer;
    }
}
