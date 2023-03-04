package week2.minji;

import java.util.*;
import java.io.*;

public class Main
{
    private static int N;
    private static int[][] scoreArr;
    private static int[][] lankArr = new int[3][1001];
    private static int[] totalLankArr = new int[4001];

    public static void main(String args[]) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        scoreArr = new int[4][N];

        //점수 입력
        for(int i=0; i<3; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0; j<N; j++){
                int score = Integer.parseInt(stringTokenizer.nextToken());
                scoreArr[i][j] = score;

                lankArr[i][score]++;
            }
        }
        //총점 입력
        for(int j=0; j<N; j++){
            for(int i=0; i<3; i++){
                scoreArr[3][j] += scoreArr[i][j];
            }
            totalLankArr[scoreArr[3][j]]++;
        }

        int count;
        for(int i=0; i < 3; i++){
            count = 1;
            for(int j=1000; j >= 0;j--){
                if(lankArr[i][j] != 0){
                    int person = lankArr[i][j];
                    lankArr[i][j] = count;
                    count += person;
                }
            }
        }
        count = 1;
        for(int i=4000; i >= 0; i--){
            if(totalLankArr[i] != 0){
                int person = totalLankArr[i];
                totalLankArr[i] = count;
                count += person;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0; i < 3; i++){
            for(int j=0; j < N;j++){
                int score = scoreArr[i][j];
                stringBuilder.append(lankArr[i][score] + " ");
            }
            stringBuilder.append("\n");
        }
        for(int i=0; i < N; i++){
            stringBuilder.append(totalLankArr[scoreArr[3][i]] + " ");
        }

        System.out.println(stringBuilder);
    }
}