import java.util.*;

public class Solution_BOJ_카잉달력_sangwon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int ans = -1;
			
			
			for(int i=0; i<=M; i++) {
				int num = i*N;
				
				
				if((num + y - x) % M == 0) {
					ans = num + y;
					break;
				}
			}
			
			System.out.println(ans);
		}
	}

}
