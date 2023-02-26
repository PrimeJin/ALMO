import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static boolean[] check;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N+1];
        memo = new int[M+1];
        solution(1);
        System.out.println(sb);
    }

    public static void solution(int idx) {
        if(idx == M+1) {
            for(int i=1; i<=M; i++) {
                sb.append(memo[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++) {
            if(!check[i]) {
                check[i] = true;
                memo[idx] = i;
                solution(idx+1);
                check[i] = false;
            }
        }
    }
}
