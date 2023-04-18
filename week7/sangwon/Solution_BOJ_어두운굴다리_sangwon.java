import java.util.*;

public class Solution_BOJ_어두운굴다리_sangwon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //굴다리 길이
		int M = sc.nextInt(); //가로등 개수
		
		int[] x = new int[M]; //설치할 위치
		

		
		for(int i=0; i<M; i++) {
			x[i] = sc.nextInt();
		}
		int answer = 0;
		int lo = 1;
		int hi = N;

		while(lo <= hi) {
			int mid = (hi + lo) / 2; //기둥의 높이 지정
			//check가 true로 바뀐다는것 -> 비출 수 없는 부분이 존재한다는것
			boolean check = false;
			boolean check2 = false; //마지막 부분만 체크
			//이전 지점 좌표
			int prev = 0;
			for(int i=0; i<M; i++) {
				//현재 가로등에서 이전 지점까지 비출 수 있을 경우
				if(prev >= x[i] - mid) {
					//현재 가로등에서 비추는 최대거리를 prev로 업데이트
					prev = x[i] + mid;
				} else {
					check = true;
					break;
				}
			}
			//prev가 N이상이어야 N 너머까지 불빛이 비춘다는 뜻
			if(N <= prev) check2 = false;
			else check2 = true;

			
			//모두 통과한 값
			if(!check && !check2) {
				answer = mid;
				hi = mid-1; //더 작은 값을 찾기 위해
			} else {
				lo = mid+1;
			}
		}
		

		System.out.println(answer);
	}
}
