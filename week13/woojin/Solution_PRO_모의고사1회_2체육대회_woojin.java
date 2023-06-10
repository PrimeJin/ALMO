import java.util.*;
class Solution {
    static Player[][] topScore;
    static boolean[] checkStudent;
    static int student, sport;
    static int max;
    public int solution(int[][] ability) {
        int answer = 0;
        max = 0;
        student = ability.length;
        sport = ability[0].length;
        
        topScore = new Player[sport][sport];
        checkStudent = new boolean[student];
        for(int i=0; i<sport; i++) {  //종목
            Player[] tmpArr = new Player[student];
            for(int j=0; j<student; j++) {
                tmpArr[j] = new Player(j, ability[j][i], i);
            }
            Arrays.sort(tmpArr, (o1, o2) -> o2.score - o1.score);
            
            for(int j=0; j<sport; j++) {
                topScore[i][j] = tmpArr[j];
            }
        }
        
        recursive(0, 0);
        
        return max;
    }
        
    public static void recursive(int spIdx, int sum) {
        if(spIdx == sport) {
            max = Math.max(max, sum);
            return ;
        }
        
        for(int i=0; i<sport; i++) {
            if(!checkStudent[topScore[spIdx][i].studentIdx]) {
                checkStudent[topScore[spIdx][i].studentIdx] = true;
                recursive(spIdx+1, sum + topScore[spIdx][i].score);
                checkStudent[topScore[spIdx][i].studentIdx] = false;
            }
        }
        
    }
    
    static class Player {
        int studentIdx;
        int sportIdx;
        int score;
        
        public Player(int studentIdx, int score, int sportIdx) {
            this.studentIdx = studentIdx;
            this.score = score;
            this.sportIdx = sportIdx;
        }
    }
}