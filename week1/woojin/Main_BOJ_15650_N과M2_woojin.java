import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean check[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		check = new boolean[N];
		
		solution(0,0);
		System.out.println(sb);
	}
	
	public static void solution(int start, int cnt) {
		if(cnt == M) {
			for(int i=0; i<N; i++) {
				if(check[i]) {
					sb.append(i+1).append(" ");
				}
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(!check[i]) {
				check[i] = true;  //방문처리
				solution(i+1, cnt+1);
				check[i] = false;
			}
		}
	}
}
