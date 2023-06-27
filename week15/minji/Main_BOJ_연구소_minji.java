import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main
{
    public static int N,M;
    public static int[][] map;
    //상 우 하 좌
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static ArrayList<Point> safeArea = new ArrayList<>();
    public static ArrayList<Point> virusArea = new ArrayList<>();
    public static int max = Integer.MIN_VALUE;

    public static void main(String args[]) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if(map[i][j] == 0) safeArea.add(new Point(i,j));
                else if (map[i][j] == 2) virusArea.add(new Point(i,j));
            }
        }

        dfs(0,0, new Point[3]);

        StringBuilder stringBuilder = new StringBuilder().append(max);
        System.out.println(stringBuilder);
    }

    private static void dfs(int count, int index, Point[] select) {
        if(count >= 3){
            int safe = getSafe(select);
            max = Math.max(max,safe);
            return;
        }

        for (int i = index; i < safeArea.size(); i++) {
            select[count] = safeArea.get(i);
            dfs(count+1,i+1,select);
        }
    }

    private static int getSafe(Point[] select) {

        int[][] mapCopy = new int[N][M];
        for (int i = 0; i < N; i++) {
            mapCopy[i] = map[i].clone();
        }

        for (int i = 0; i < 3; i++) {
            mapCopy[select[i].x][select[i].y] = 1;
        }

        for (int i = 0; i < virusArea.size(); i++) {
            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(virusArea.get(i).x,virusArea.get(i).y));

            while(!queue.isEmpty()){
                Point now = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M || mapCopy[nx][ny] != 0) continue;
                    mapCopy[nx][ny] = 2;
                    queue.add(new Point(nx,ny));
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(mapCopy[i][j] == 0) result++;
            }
        }

        return result;
    }
}
