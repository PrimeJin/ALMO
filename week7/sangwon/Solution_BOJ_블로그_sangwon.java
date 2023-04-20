import java.util.*;

public class Solution_BOJ_블로그_sangwon {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int X = sc.nextInt();
		int[] visitor = new int[N];
		
		for(int i=0; i<N; i++) {
			visitor[i] = sc.nextInt();
		}
		
		
		//슬라이딩 윈도우
		int sum = 0;
		for(int i=0; i<X; i++) {
			sum += visitor[i]; //visitor[0] ~ visitor[X-1]까지의 합
		}		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		pq.add(sum);		
				
		for(int i=0; i<N-X; i++) {
			sum = sum - visitor[i] + visitor[i + X];
			pq.add(sum);
		}
		
		int maxVisit = pq.poll();
		int maxCount = 1;
		while(!pq.isEmpty()) {
			int n = pq.poll();
			if(n == maxVisit) maxCount++;
		}
		
		if(maxVisit == 0) {
			System.out.println("SAD");
			return;
		} else {
			System.out.println(maxVisit);
			System.out.println(maxCount);
		}
		
	}
}
