import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] liquid = new int[N];
		for(int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		
		int head = 0, tail = N -1;
		int min = Integer.MAX_VALUE;
		int[] result = new int[2];
		while(head < tail) {
			int tmp = liquid[head] + liquid[tail];
			
			if(Math.abs(tmp) < min) {
				min = Math.abs(tmp);
				result[0] = liquid[head];
				result[1] = liquid[tail];
			}
			
			
			if(tmp <= 0) head++;
			else tail--;
		}
		
		System.out.println(result[0] + " " + result[1]);
	}
}
