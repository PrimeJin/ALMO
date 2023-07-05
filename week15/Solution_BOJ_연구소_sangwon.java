import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int max = Integer.MIN_VALUE;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //세로 크기 N
		M = sc.nextInt(); //가로 크기 M
		
		map = new int[N][M]; //연구소 지도
	
		ArrayList<int[]> safe = new ArrayList<>(); //안전지역 위치

		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt(); //지도 입력
				if(map[i][j] == 0) safe.add(new int[] {i, j});
			}
		}
		
		dfs(0);
		
		System.out.println(max);
		
	}
	
	static void dfs(int wall) {
		if(wall == 3) {
			bfs();
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(wall+1);
					map[i][j] = 0;
				}
			}
		}
	}
	

	
	
	static void bfs() {
		Queue<int[]> virus = new LinkedList<>(); //바이러스 위치

		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 2) {
					virus.add(new int[] {r, c});
				}
			}
		}
		
		int[][] newMap = new int[N][M];
		for(int i=0; i<N; i++) newMap[i] = map[i].clone();
		
		while(!virus.isEmpty()) {
			int[] arr = virus.poll();
			int r = arr[0];
			int c = arr[1];
//			System.out.println(r + " " + c);
			//사방탐색
			for(int n=0; n<4; n++) {
				int nr = r + dr[n];
				int nc = c + dc[n];

				if(nr < N && nr >= 0 && nc < M && nc >= 0 && newMap[nr][nc] == 1) continue;
				
				if(nr < N && nr >= 0 && nc < M && nc >= 0 && newMap[nr][nc] == 0) {
					newMap[nr][nc] = 2;
					virus.add(new int[] {nr, nc});
				}
			}
	
		}
//		printMap(newMap);
		max = Math.max(max, countMax(newMap));
	}
	
	static int countMax(int[][] map) {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) cnt++;
			}
		}
		
		return cnt;
	}

	
	static void printMap(int[][] map) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}