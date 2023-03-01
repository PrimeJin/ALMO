import java.util.*;
import java.io.*;


public class Main
{
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];

        for(int i = 0; i < N; i++){
            char[] input = br.readLine().toCharArray();    
            for(int j = 0; j < N; j++){
                map[i][j] = input[j];
            }
        }
        
        LinkedList<Integer> result = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == '1'){
                    int cnt = 0;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(j); queue.add(i);
                    map[i][j] = '0';
                    while(!queue.isEmpty()){
                        int x = queue.remove();
                        int y = queue.remove();
                        cnt++;
                        for(int k = 0; k < 4; k++){
                            int xx = x + dx[k];
                            int yy = y + dy[k];
                            if(xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
                            if(map[yy][xx] == '0') continue;
                            map[yy][xx] = '0';
                            queue.add(xx); queue.add(yy);
                        }
                    }    
                    result.add(cnt);
                }   
            }
        }
        Collections.sort(result);
        sb.append(result.size()).append("\n");
        for(int i = 0; i < result.size(); i++){
            sb.append(result.get(i)).append("\n");
        }
        System.out.print(sb);
    }
    
}
