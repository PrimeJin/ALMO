package week2.minji;

import java.util.*;
import java.io.*;

public class Solution_PRO_등대_minji
{

    public static void main(String args[]) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int bagW = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int result = 0;

        int[][] arr = new int[10001][1];
        for(int i = 0; i < N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int W = Integer.parseInt(stringTokenizer.nextToken());
            int V = Integer.parseInt(stringTokenizer.nextToken());
            arr[V][0] += W;
        }

        for(int i = 10000; i > 0; i--){
            int nowW = arr[i][0];
            if(nowW != 0){
                if(bagW - nowW < 0){
                    result += i*bagW;
                    bagW = 0;
                }else{
                    result += nowW*i;
                    bagW -= nowW;
                }
            }

            if(bagW == 0) break;
        }

        System.out.println(result);

    }
}
