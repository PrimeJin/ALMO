import java.util.*;
class Solution {
    public static int answer = 0;

    public int solution(int[][] board, int[][] skill) {
        int sizeX = board.length;
        int sizeY = board[0].length;
        int[][] prefixBoard = new int[sizeX+1][sizeY+1];

        for(int[] nowSkill : skill){
            int degree = nowSkill[0] == 1? -nowSkill[5] : nowSkill[5];

            prefixBoard[nowSkill[1]][nowSkill[2]] += degree;
            prefixBoard[nowSkill[1]][nowSkill[4]+1] -= degree;
            prefixBoard[nowSkill[3]+1][nowSkill[2]] -= degree;
            prefixBoard[nowSkill[3]+1][nowSkill[4]+1] += degree;
        }

        for(int i=1; i<sizeX;i++){
            prefixBoard[i][0] += prefixBoard[i-1][0];
        }

        for(int i=1; i<sizeY;i++){
            prefixBoard[0][i] += prefixBoard[0][i-1];
        }

        for(int i=1; i<sizeX; i++){
            for(int j=1; j<sizeY; j++){
                prefixBoard[i][j] += prefixBoard[i][j-1] + prefixBoard[i-1][j] - prefixBoard[i-1][j-1];
            }
        }

        for(int i=0; i<sizeX; i++){
            for(int j=0; j<sizeY; j++){
                if(board[i][j] + prefixBoard[i][j] > 0){
                    answer++;
                }
            }
        }

        return answer;
    }
}