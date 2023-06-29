import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] cityMap;
    public static int citySize,busSize;
    public static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        citySize = Integer.parseInt(bufferedReader.readLine());
        busSize = Integer.parseInt(bufferedReader.readLine());

        cityMap = new int[citySize][citySize];

        for (int i = 0; i < busSize; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken())-1;
            int end = Integer.parseInt(stringTokenizer.nextToken())-1;
            int cost = Integer.parseInt(stringTokenizer.nextToken());

            if(cityMap[start][end] != 0){
                cityMap[start][end] = Math.min(cost,cityMap[start][end]);
            }else{
                cityMap[start][end] = cost;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < citySize; i++) {
            visited = new int[citySize];
            floyd(i);

            for(int j = 0; j < citySize; j++){
                stringBuilder.append(visited[j]).append(" ");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static void floyd(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int i=0; i<citySize;i++){
                if(cityMap[now][i] == 0 || i==start) continue;

                if(visited[i] == 0 || visited[now] + cityMap[now][i] < visited[i]){
                    visited[i] = visited[now] + cityMap[now][i];
                    queue.add(i);
                }
            }
        }
    }
}
