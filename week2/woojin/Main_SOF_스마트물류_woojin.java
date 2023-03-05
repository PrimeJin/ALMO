import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  //라인 길이
        int K = Integer.parseInt(st.nextToken());  //부품을 집을 수 있는 거리

        char[] lineArr = new char[N];
        String line = br.readLine();
        for(int i=0; i<N; i++) {
            lineArr[i] = line.charAt(i);
        }

        int count = 0;
        for(int i=0; i<N; i++) {
            if(lineArr[i] == 'P') {
                for(int j=-K; j<=K; j++) {
                    if(0<=(i+j)&&(i+j)<N) {
                        if(lineArr[i+j] == 'H') {
                            count++;
                            lineArr[i+j] = 'X';
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}