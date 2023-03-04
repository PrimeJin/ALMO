package week2.minji;

import java.util.*;
import java.io.*;
public class Main {
    private static int N;
    private static int K;
    private static int robot;
    private static int maxRobot = 0;

    public static void main(String args[]) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringtokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringtokenizer.nextToken());
        K = Integer.parseInt(stringtokenizer.nextToken());

        String line = bufferedReader.readLine();
        char[] lineArr = line.toCharArray();

        for(int index=0; index<N; index++){
            if(lineArr[index] == 'P'){
                for(int i=index-K; i <= index+K; i++){
                    if(i >= 0 && i<N && lineArr[i] == 'H'){
                        lineArr[i] = 'T';
                        maxRobot++;
                        break;
                    }
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder().append(maxRobot);
        System.out.println(stringBuilder);
    }

}
