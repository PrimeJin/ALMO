import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static int[][] map;
	static int N, M;
	static List<Position> empty;  //비어있는 칸 전부 담은 list
	static List<Position[]> comboList;  //벽 3개 세우는 조합 list
	static boolean[] listCheck;  //조합 구할때 방문체크 배열
	static Position[] result;  //조합 (3개 좌표)담은 결과 배열
	static List<Position> virusList;  //바이러스들의 좌표 담은 list
	static int[] dy = {0, 1, 0, -1};  //우 하 좌 상
	static int[] dx = {1, 0, -1, 0};  //우 하 좌 상
	static boolean[][] visited;  //바이러스 전염에서 방문체크 배열
	static int infect;  //빈칸이었는데 바이러스 전염된 칸 수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		empty = new ArrayList<>();  //빈칸 경우의 수 다 넣기
		virusList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					empty.add(new Position(i, j));
				} else if(map[i][j] == 2) {
					virusList.add(new Position(i, j));
				}
			}
		}
		
		comboList = new ArrayList<>();
		listCheck = new boolean[empty.size()];
		result = new Position[3];
		
		comb(0, 0, empty.size());
		
		int max = 0;
		for(int i=0; i<comboList.size(); i++) {
			for(int j=0; j<3; j++) {
				int tmpY = comboList.get(i)[j].y;
				int tmpX = comboList.get(i)[j].x;
				map[tmpY][tmpX] = 1;
			}
			
			visited = new boolean[N][M];
			infect = 0;  //전염된 수
			//바이러스 전염
			for(int j=0; j<virusList.size(); j++) {
				dfs(virusList.get(j));
			}
			
			max = Math.max(max, empty.size() - infect -3);  //원래 맨처음 빈칸개수 - 전염된 수 - 벽세운 개수3
			
			//map 다시 돌려놓기 (벽없애기)
			for(int j=0; j<3; j++) {
				int tmpY = comboList.get(i)[j].y;
				int tmpX = comboList.get(i)[j].x;
				map[tmpY][tmpX] = 0;
			}
		}
		
		System.out.print(max);
	}
	
	public static void comb(int start, int cnt, int size) {  //벽 3개 세우는 조합 구하기
		if(cnt == 3) {
			comboList.add(result.clone());
			return;
		}
		
		for(int i=start; i<size; i++) {
			if(!listCheck[i]) {
				listCheck[i] = true;
				result[cnt] = empty.get(i);
				comb(i+1, cnt+1, size);
				listCheck[i] = false;
			}
		}
	}
	
	public static void dfs(Position pos) {  //바이러스 전염작업
		for(int i=0; i<4; i++) {
			int ny = pos.y + dy[i];
			int nx = pos.x + dx[i];
			
			if(ny<0 || ny>=N || nx<0 || nx>=M) continue;
			
			if(!visited[ny][nx] && map[ny][nx] == 0) {
				visited[ny][nx] = true;
				infect++;
				dfs(new Position(ny, nx));
			}
		}
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
