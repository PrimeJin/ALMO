import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String input = br.readLine();
		
		Stack<Integer> stack = new Stack<>();
		
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			//i번째 자리의 숫자 n
			int n = input.charAt(i) - '0';
			
			//스택이 비었으면 우선 삽입
			if(stack.isEmpty()) stack.push(n);
			else {
				while(true) {
					if(stack.isEmpty()) {
						stack.push(n);
						break;
					}
					
					if(cnt == K) {
						stack.push(n);
						break;
					}
					
					if(n > stack.peek()) {
						stack.pop();
						cnt++;
					}
					else {
						stack.push(n);
						break;
					}
				}
			}	
		}
		
		StringBuilder sb = new StringBuilder();
		int tempCnt = 0;
		for(int i : stack) {
			sb.append(i);
			tempCnt++;
			if(tempCnt == N-K) break;
		}
		
		System.out.println(sb);
	}
}