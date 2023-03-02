import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static boolean[][] check;
	static int[] dy = {0,1,0,-1};  //우하좌상
	static int[] dx = {1,0,-1,0};  //우하좌상
	static int N;
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());  //지도 크기
		//지도 초기화
		map = new int[N][N];
		check = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = tmp.charAt(j)-'0';
			}
		}
		
		list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] > 0 && !check[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append("\n");
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void bfs(int y, int x) {
		Queue<Position> queue = new ArrayDeque<>();
		check[y][x] = true;
		queue.offer(new Position(y, x));
		
		int cnt = 1;
		while(!queue.isEmpty()) {
			Position cur = queue.poll();
			
			for(int i=0; i<4; i++) {
				int moveY = cur.y + dy[i];
				int moveX = cur.x + dx[i];
				
				if(0<=moveY&&moveY<N && 0<=moveX&&moveX<N) {  //지도 가능범위
					if(!check[moveY][moveX] && map[moveY][moveX]>0) {
						check[moveY][moveX] = true;
						queue.offer(new Position(moveY, moveX));
						cnt++;
					}
				}
			}
		}
		
		list.add(cnt);
	}
	
	
	static class Position {
		int y;
		int x;
		
		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}