import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        ArrayList<Integer> load;
        int cost;
        public Node(){
            this.load = new ArrayList<>();
            this.cost = 0;
        }
    }
    public static int[][] cityMap;
    public static int citySize,busSize;
    public static Node[][] visited;

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

        visited = new Node[citySize][citySize];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < citySize; i++) {
            for (int j = 0; j < citySize; j++) {
                visited[i][j] = new Node();
            }
            floyd(i);
        }

        for (int i = 0; i < citySize; i++) {
            for (int j = 0; j < citySize; j++) {
                stringBuilder.append(visited[i][j].cost).append(" ");
            }
            stringBuilder.append("\n");
        }

        for (int i = 0; i < citySize; i++) {
            for (int j = 0; j < citySize; j++) {
                stringBuilder.append(visited[i][j].load.size()).append(" ");
                for (int k = 0; k < visited[i][j].load.size(); k++) {
                    stringBuilder.append(visited[i][j].load.get(k)).append(" ");
                }
                stringBuilder.append("\n");
            }
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

                if(visited[start][i].cost == 0 || visited[start][now].cost + cityMap[now][i] < visited[start][i].cost){
                    visited[start][i].cost = visited[start][now].cost + cityMap[now][i];

                    if(now == start){
                        visited[start][i].load.add(start+1);
                    }else{
                        visited[start][i].load = (ArrayList<Integer>) visited[start][now].load.clone();
                    }
                    visited[start][i].load.add(i+1);

                    queue.add(i);
                }
            }
        }
    }
}
