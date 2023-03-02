import java.util.*;
import java.io.*;


public class Main
{
    static int[] search_r = {0, 1, 0, -1};
    static int[] search_c = {1, 0, -1, 0};
    static char[][] map;
    static int[][] visited;
    static int N;
    static int count = 1;

    public static void dfs(int r, int c, int value){
        visited[r][c] = value;
        //방문한 점 사방탐색
        for(int n=0; n<4; n++){
            int nr = r + search_r[n];
            int nc = c + search_c[n];
            if(nr < N && nr >= 0 && nc < N && nc >= 0 && map[nr][nc] == '1' && visited[nr][nc] == 0){
                dfs(nr, nc, value);          
            }
        }

        return;
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        map = new char[N][N];
        visited = new int[N][N];

        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = arr[i].charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == '1' && visited[i][j] == 0){
                    dfs(i, j, count++);
                }
            }
        }

        //조금 정리가 필요할듯
        System.out.println(count-1);

        int[] answer = new int[count-1];
        for(int n=1; n<count; n++){
            int cnt = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(visited[i][j] == n) cnt++;
                }
            }
            answer[n-1] = cnt;
        }    

        Arrays.sort(answer);
        for(int i=0; i<count-1; i++){
            System.out.println(answer[i]);
        }
        
    }
}