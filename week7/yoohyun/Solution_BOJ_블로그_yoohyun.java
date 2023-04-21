import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[] visit = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			visit[i] = Integer.parseInt(st.nextToken());
		}
		long max = 0;
		int seq = 0;
		for(int i = 0; i < X; i++) {
			seq += visit[i];
		}
		max = Math.max(max, seq);
		long result = 1;
		for(int i = X; i < N; i++) {
			int tmp = seq + visit[i] - visit[i - X];
			if(max == tmp) {
				result++;
			} else if(max < tmp){
				result = 1;
				max = tmp;
			}
			seq = tmp;
		}
		if(max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(result);
		}
    }
}
