import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2812_크게만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());  //숫자 자리수
		int K = Integer.parseInt(st.nextToken());  //지울 숫자 개수
		
		String num = br.readLine();
		Stack<Integer> stack = new Stack<>();
		
		int cnt = 0;  //지금까지 지운 숫자 개수
		for(int i=0; i<N; i++) {
			int cur = num.charAt(i) - '0';
			
			while(cnt < K && !stack.isEmpty() && cur>stack.peek()) {  //현재 자리수가 stack 맨뒤에 있는 수보다 크면 stack 맨뒤 수 빼고 넣기
				stack.pop();
				cnt++;
			}
			stack.push(cur);
		}
		
		//자리 숫자들이 높은 순서대로 나와서 cnt가 K보다 덜 채워진 경우 남은 K-cnt 개수만큼 숫자 빼고 출력
		if(cnt < K) {
			for(int i=0; i<K-cnt; i++) {
				stack.pop();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int x : stack) {
			sb.append(x);
		}
		
		System.out.print(sb);
	}
	
}
