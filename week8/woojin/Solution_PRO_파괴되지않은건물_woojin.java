import java.util.*;
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int boardRowLen = board.length;
        int boardColLen = board[0].length;
        
        int[][] preSum = new int[boardRowLen+1][boardColLen+1];  //누적합 배열
        
        for(int i=0; i<skill.length; i++) {
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            
            if(skill[i][0] == 1) {  //공격
                preSum[r1][c1] -= degree;  //왼쪽위
                preSum[r1][c2+1] += degree;  //오른쪽 위
                preSum[r2+1][c1] += degree;  //왼쪽 아래
                preSum[r2+1][c2+1] -= degree;  //오른쪽 아래
            } else {  //회복
                preSum[r1][c1] += degree;  //왼쪽위
                preSum[r1][c2+1] -= degree;  //오른쪽 위
                preSum[r2+1][c1] -= degree;  //왼쪽 아래
                preSum[r2+1][c2+1] += degree;  //오른쪽 아래
            }
        }        
        
        //가로 누적합
        for(int i=0; i<boardRowLen+1; i++) {
            for(int j=0; j<boardColLen; j++) {
                preSum[i][j+1] += preSum[i][j];
            }
        }
        
        //세로 누적합
        for(int i=0; i<boardColLen+1; i++) {
            for(int j=0; j<boardRowLen; j++) {
                preSum[j+1][i] += preSum[j][i];
            }
        }
        
        
        for(int i=0; i<boardRowLen; i++) {
            for(int j=0; j<boardColLen; j++) {
                if(preSum[i][j] + board[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
    
}