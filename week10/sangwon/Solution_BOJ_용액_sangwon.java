import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)	arr[i] = Integer.parseInt(st.nextToken());

		int lp = 0; //왼쪽 포인터
		int rp = N-1; //오른쪽 포인터
		
		//제일 0에 가까운 숫자 찾기
		int pre = arr[lp] + arr[rp];
		int prelp = lp;
		int prerp = rp;
		while(lp < rp) {
			int ans = arr[lp] + arr[rp];
			
			//먼저 판단해야할거 : 두 포인터의 합이 양수인가 음수인가
			
			//최솟값 갱신
			if(Math.abs(ans) <= Math.abs(pre)) {
				pre = ans;
				prelp = lp;
				prerp = rp;
			} 
			
			if(ans == 0) break;
			
			if(ans > 0) {
				rp--;
			}
			
			if(ans < 0) {
				lp++;
			}
		}
		
		System.out.println(arr[prelp] + " " + arr[prerp]);
	}
}
