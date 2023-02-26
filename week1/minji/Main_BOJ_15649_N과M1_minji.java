import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_56238173_minji {
    private static int N;
    private static int M;
    private static int[] result;

    //3 1 => 3개중 1개
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        boolean[] visited = new boolean[N+1];
        result = new int[M];
        permutation(visited,0);
    }

    private static void permutation(boolean[] visited, int count) {
        if(count == M){
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();

            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i]){
                visited[i] = true;
                result[count] = i;
                permutation(visited,count+1);
                visited[i] = false;
            }

        }
        return;
    }


}
