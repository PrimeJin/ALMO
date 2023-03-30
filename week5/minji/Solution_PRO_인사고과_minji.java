class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int wonScore = scores[0][0] + scores[0][1];

        if(!check(0,scores)) return -1;

        for(int i=1;i< scores.length; i++){
            int anotherScore = scores[i][0] + scores[i][1];
            if(anotherScore > wonScore){
                if(check(i, scores)){
                    answer++;
                }
            }
        }

        return answer;
    }
    public boolean check( int another, int[][] scores){

        for(int i =0; i < scores.length; i++){
            boolean flag = true;
            if(scores[i][0] > scores[another][0]) flag = false;
            if(scores[i][1] > scores[another][1] && !flag) return false;
        }

        return true;
    }
}