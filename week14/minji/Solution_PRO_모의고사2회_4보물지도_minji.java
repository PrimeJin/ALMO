import java.awt.*;
import java.util.*;
import java.lang.*;

class Solution {
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,1,0,-1,0};
    public static class Point{
        int x;
        int y;
        int shoe;

        public Point(int x,int y, int shoe){
            this.x = x;
            this.y = y;
            this.shoe = shoe;
        }
    }

    public int solution(int n, int m, int[][] hole) {
        int answer = 0;
        int[][][] map = new int[2][n+1][m+1];

        for(int i=0; i<2;i++){
            for(int j=1; j<=n;j++){
                Arrays.fill(map[i][j],Integer.MAX_VALUE);
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1,1,0));
        map[0][1][1] = 0;

        for(int i=0; i<hole.length;i++){
            map[0][hole[i][0]][hole[i][1]] = -1;
            map[1][hole[i][0]][hole[i][1]] = -1;
        }

        while(!queue.isEmpty()){
            Point now = queue.poll();

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx > 0 && nx <= n && ny > 0 && ny <= m
                        && map[now.shoe][nx][ny] != -1
                        && map[now.shoe][now.x][now.y]+1 < map[now.shoe][nx][ny]){
                    //큐에 저장
                    queue.add(new Point(nx,ny,now.shoe));
                    map[now.shoe][nx][ny] = map[now.shoe][now.x][now.y]+1;
                }
            }

            if(now.shoe == 0){
                for(int i=0; i<4; i++){
                    int nx = now.x + (2*dx[i]);
                    int ny = now.y + (2*dy[i]);

                    if(nx > 0 && nx <= n && ny > 0 && ny <= m
                            && map[now.shoe][nx][ny] != -1
                            && map[now.shoe][now.x][now.y]+1 < map[1][nx][ny]){
                        //큐에 저장
                        queue.add(new Point(nx,ny,1));
                        map[1][nx][ny] = map[now.shoe][now.x][now.y]+1;
                    }
                }
            }
        }

        answer = Math.min(map[0][n][m],map[1][n][m]);
        if(answer == Integer.MAX_VALUE) answer = -1;

        return answer;
    }
}