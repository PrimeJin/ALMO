class Solution {
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public int[] solution(String command) {
        int[] answer = {};
        int[] robot = {0,0,0};

        for(char order : command.toCharArray()){
            if(order == 'R'){
                robot[2] = (robot[2]+1)%4;
            }else if(order == 'L'){
                if(robot[2]-1 < 0){
                    robot[2] = 3;
                }else{
                    robot[2] -=1;
                }
            }else if(order == 'G'){
                robot[0] += dx[robot[2]];
                robot[1] += dy[robot[2]];
            }else if(order == 'B'){
                int direct = (robot[2]+2)%4;
                robot[0] += dx[direct];
                robot[1] += dy[direct];
            }
        }

        answer = new int[2];
        answer[0] = robot[0];
        answer[1] = robot[1];
        return answer;
    }
}