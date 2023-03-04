import java.util.*;
import java.io.*;


public class Main
{
    static int N,K;
    static char[] factory;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        factory = br.readLine().toCharArray();

        int result = 0;
        for(int i = 0; i < N; i++){
            if(factory[i] == 'H' || factory[i] == 'A') continue;
            if(pick(i)) result++;
        }

        System.out.print(result);

    }
    public static boolean pick(int cur){
        for(int k = K; k >= 1; k--){
            if(cur - k < 0) continue;
            if(factory[cur-k] == 'P' || factory[cur - k] == 'A') continue;
            factory[cur-k] = 'A'; 
            return true;
        }
        for(int k = 1; k <= K; k++){
            if(cur + k >= N) continue;
            if(factory[cur + k] == 'P' || factory[cur + k] == 'A') continue;
            factory[cur+k] = 'A'; 
            return true;
        }
        return false;
    }
}
