import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N,M,X;
    public static int[][] townMap;
    public static int[] goCost;
    public static int[] comeCost;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        X = Integer.parseInt(stringTokenizer.nextToken());

        townMap = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int cost = Integer.parseInt(stringTokenizer.nextToken());
            townMap[start][end] = cost;
        }

        goCost = new int[N+1];
        comeCost = new int[N+1];

        goBFS();
        comeBFS();

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max,goCost[i]+comeCost[i]);
        }

        System.out.println(max);
    }

    private static void comeBFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);

        while(!queue.isEmpty()){
            int now = queue.poll();

            for (int i = 1; i <= N; i++) {
                if(townMap[now][i] == 0 || i == now || i == X) continue;
                if(comeCost[i] == 0 || comeCost[i] > townMap[now][i] + comeCost[now]){
                    comeCost[i] = townMap[now][i] + comeCost[now];
                    queue.add(i);
                }
            }
        }
    }

    private static void goBFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);

        while(!queue.isEmpty()){
            int now = queue.poll();

            for (int i = 1; i <= N; i++) {
                if(townMap[i][now] == 0 || i == now || i == X) continue;
                if(goCost[i] == 0 || goCost[i] > townMap[i][now] + goCost[now]){
                    goCost[i] = townMap[i][now] + goCost[now];
                    queue.add(i);
                }
            }
        }
    }
}
