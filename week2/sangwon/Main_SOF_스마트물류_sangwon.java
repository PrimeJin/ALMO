import java.util.*;
import java.io.*;


public class Main
{
    static int N;
    static int K;

    static List<Integer> robots;
    static char[] line;
    static int max = -1;

    public static void dfs(int st) {
        if(st == robots.size()){
            int cnt = 0;
            for(char ch : line){
                if(ch == 'C') cnt++;
            }
            max = cnt;
            return;
        }  //마지막 로봇까지 탐색하면 종료

        boolean check = false;
        int idx = robots.get(st); //로봇의 좌표

        for(int i=idx-K; i<=idx+K; i++){
            if(i >= 0 && i < N && line[i] == 'H'){
                check = true;
                line[i] = 'C'; //로봇이 집은 부품을 'C'로 표시
                dfs(st+1);
                break;
                // line[i] = 'H';                
            } 
        }
        if(!check) dfs(st+1);
    }


    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());//줄의 길이
        K = Integer.parseInt(st.nextToken()); //최대 뻗을수 있는 거리

        String str = br.readLine(); // 문자열

        line = new char[N];
        robots = new ArrayList<>();
        for(int i=0; i<N; i++){
            line[i] = str.charAt(i);
            if(line[i] == 'P') robots.add(i); //로봇위치 저장한 리스트
        }

        dfs(0);

        System.out.println(max);
    }
}