package week2.minji;

import java.util.*;
import java.io.*;
import java.awt.*;


public class Main
{
    private static int mapSize;
    private static int[][] map;
    private static int blockCount = 0;
    private static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}}; //상우하좌

    public static void main(String args[]) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        mapSize = Integer.parseInt(bufferedReader.readLine());
        map = new int[mapSize][mapSize];
        PriorityQueue<Integer> blockList = new PriorityQueue<>();

        //입력
        for(int i=0; i < mapSize; i++){
            char[] Arr = bufferedReader.readLine().toCharArray();

            for(int j=0; j < mapSize; j++){
                int isBlock  = Arr[j] - '0';

                map[i][j] = isBlock;
            }
        }

        for(int i=0; i < mapSize; i++){
            for(int j=0; j < mapSize; j++){
                if(map[i][j] == 1){
                    blockCount++;
                    blockList.add(dfs(new Point(i,j)));
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder().append(blockCount).append("\n");

        for(int i=0, size = blockList.size();i < size ;i++){
            stringBuilder.append(blockList.poll()).append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static int dfs(Point startPoint){
        Queue<Point> queue = new LinkedList<>();
        // boolean[][] visited = new boolean[mapSize][mapSize];

        // visited[startPoint.x][startPoint[y]] = true;
        // map[startPoint.x][startPoint.y] = 2;
        queue.add(startPoint);
        map[startPoint.x][startPoint.y] = 2;

        int count = 0;

        while(!queue.isEmpty()){
            Point nowPoint = queue.poll();
            // System.out.println("map" + " " + nowPoint.x + " " + nowPoint.y);
            count++;

            for(int i=0 ; i < 4;i++){
                int nx = nowPoint.x + delta[i][0];
                int ny = nowPoint.y + delta[i][1];
                Point nextPoint = new Point(nx,ny);
                // System.out.println(nextPoint.toString());

                if(nextPoint.x >= 0 && nextPoint.x < mapSize && nextPoint.y >= 0 && nextPoint.y < mapSize
                        && map[nextPoint.x][nextPoint.y] == 1){
                    // System.out.println("L 1");
                    queue.add(nextPoint);
                    map[nextPoint.x][nextPoint.y] = 2;
                }
            }


            // for(int i=0; i < mapSize; i++){
            //     for(int j=0; j < mapSize; j++){
            //         System.out.print(map[i][j] + " ");
            //     }
            //     System.out.println();
            // }
        }

        return count;
    }
}
