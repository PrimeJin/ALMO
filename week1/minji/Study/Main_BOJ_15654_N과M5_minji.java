package week1.minji.Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main_BOJ_56323286_minji {
        private static int M;
        private static int N;
        private static int[] numberArr;
        private static int[] result;
        private static boolean[] visited;
        private static StringBuilder stringBuilder = new StringBuilder();

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            N = Integer.parseInt(stringTokenizer.nextToken());
            M = Integer.parseInt((stringTokenizer.nextToken()));

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            numberArr = new int[N];
            for (int i = 0; i < N; i++) {
                numberArr[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            Arrays.sort(numberArr);

            result = new int[M];
            visited = new boolean[N+1];
            logic(0);

            System.out.println(stringBuilder);

        }

        private static void logic(int count) {
            if(count == M){
                for (int i = 0; i < M; i++) {
                    stringBuilder.append(result[i]).append(" ");
                }
                stringBuilder.append("\n");
                return;
            }

            for (int i = 0; i < N; i++) {
                if(!visited[i]){
                    result[count] = numberArr[i];
                    visited[i] = true;
                    logic(count + 1);
                    visited[i] = false;
                }
            }

        }
}
