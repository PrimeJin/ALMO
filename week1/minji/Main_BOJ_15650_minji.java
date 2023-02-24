package week1.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_15650_minji {
    private static int M;
    private static int N;
    private static boolean[] visited;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N+1];
        result = new int[M];
        combination(visited, 0, 1);



    }

    private static void combination(boolean[] visited, int count, int start) {
        if(count == M){
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= N; i++) {
            if(!visited[i]){
                visited[i] = true;
                result[count] = i;
                combination(visited,count+1,i+1);
                visited[i] = false;
            }
        }
    }
}

