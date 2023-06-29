import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    
    
    class Robot {
        int dir; //delta배열의 index: 0 = left, 1 = up, 2 = right, 3 = down;
        int x; //x좌표
        int y; //y좌표
        
        //로봇 초기화
        public Robot(){
            this.dir = 1;
            this.x = 0;
            this.y = 0;
        }
        
        //로봇이 오른쪽으로 90도 회전
        void turnRight(){
            this.dir = (this.dir + 1) % 4;
        }
        
        //로봇이 왼쪽으로 90도 회전
        void turnLeft(){
            this.dir = (this.dir + 3) % 4;
        }
        
        void goStraight(){
            this.x += dx[this.dir];
            this.y += dy[this.dir];
        }
        
        void goBack(){
            this.x -= dx[this.dir];
            this.y -= dy[this.dir];
        }
    }
    
    
    
    public int[] solution(String command) {
        int[] answer = new int[2];
        
        Robot r = new Robot();
        
        for(int i=0; i<command.length(); i++){
            switch(command.charAt(i)){
                case 'R':
                    r.turnRight();
                    break;
                case 'L':
                    r.turnLeft();
                    break;
                case 'G':
                    r.goStraight();
                    break;
                case 'B':
                    r.goBack();
                    break;
            }
        }
        
        answer[0] = r.x;
        answer[1] = r.y;
        
        return answer;
    }
}