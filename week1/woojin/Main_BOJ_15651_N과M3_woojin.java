import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] memo;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        memo = new int[M];
        solution(0,0);
        System.out.print(sb);
    }

    public static void solution(int start, int cnt) {
        if(cnt == M) {
            for(int i=0; i<M; i++) {
                sb.append(memo[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++) {
            memo[cnt] = i+1;
            solution(i+1, cnt+1);
        }
    }
}
