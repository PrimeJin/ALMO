import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int r = board.length;
        int c = board[0].length;
        
        int[][] sum = new int[r+1][c+1];
        
        //스킬 횟수만큼 반복
        for(int i=0; i<skill.length; i++){
            int type = (int)Math.pow(-1, skill[i][0]); //1이면 공격, 2면 회복
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int deg = skill[i][5]; //수치
            
            //누적 합을 위한 포인터 설정
            sum[r1][c1] += type*deg; //시작점이니까 +
            sum[r1][c2+1] -= type*deg; //가로 끝나는점 -
            sum[r2+1][c1] -= type*deg; //세로 끝나는점 -
            sum[r2+1][c2+1] += type*deg; //가로, 세로 2번 -가 이루어지므로 +로 보완
        }
        
        for(int i=1; i<c; i++){
            sum[0][i] += sum[0][i-1];
        }
        
        for(int i=1; i<r; i++){
            sum[i][0] += sum[i-1][0];
        }
  
        
        for(int i=1; i<r; i++){
            for(int j=1; j<c; j++){
                sum[i][j] += sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }
        
        
        //전체 board 순회하면서 1 이상인 값만 세기
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j] + sum[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}