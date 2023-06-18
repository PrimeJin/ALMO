class Solution {
    public int[] solution(String command) {
        int[] answer = new int[2];
        int len = command.length();
        
        int dir = 0;
        int y=0, x=0;
        int[] dy = {1, 0, -1, 0};  //상 우 하 좌
        int[] dx = {0, 1, 0, -1};
        for(int i=0; i<len; i++) {
            char cmd = command.charAt(i);
            switch(cmd) {
                case 'R':
                    dir++;
                    dir %= 4;
                    break;
                case 'L':
                    if(dir == 0) {
                        dir = 3;
                    } else {
                        dir--;
                    }
                    // dir %/ 4;
                    break;
                case 'G':
                    y += dy[dir];
                    x += dx[dir];
                    break;
                case 'B':
                    int opDir = (dir+2)%4;
                    y += dy[opDir];
                    x += dx[opDir];
                    break;
            }
        }
        answer[0] = x;
        answer[1] = y;
        
        
        return answer;
    }
}