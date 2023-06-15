import java.lang.*;

class Solution {
    public static int object;
    public static int student;
    public static int max;

    public int solution(int[][] ability) {
        int answer = 0;
        object = ability[0].length;
        student = ability.length;

        dfs(0, 0, ability,0);

        answer = max;
        return answer;
    }

    public static void dfs(int count, int sum, int[][] ability, int mask){
        if(count == object){
            max = Math.max(max,sum);
            return;
        }

        for(int i=0; i<student;i++){
            if((mask & (1<<i+1)) > 0) continue;

            dfs(count+1, sum+ability[i][count],ability, mask+(1<<i+1));
        }
    }
}