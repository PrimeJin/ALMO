import java.util.*;
import java.io.*;


public class Main
{
    public static class Rank implements Comparable<Rank>{
        int index;
        int score;

        public Rank(int index, int score){
            this.index = index;
            this.score = score;
        }

        public int compareTo(Rank rank){
            return Integer.compare(this.score, rank.score);
        }
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Rank[] arr = new Rank[N];
        int[] sum = new int[N];
        Rank[] total = new Rank[N];
        int[][] result = new int[N][4];
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[j] = new Rank(j, Integer.parseInt(st.nextToken()));
                sum[j] += arr[j].score;
            }
            Arrays.sort(arr);
            // 탐색
            for(int j = 0; j < N; j++){
                int last_index = binary_search(arr, arr[j].score);
                int rank = N - last_index + 1;

                result[arr[j].index][i] = rank;
            }
        }
        for(int j = 0; j < N; j++){
            total[j] = new Rank(j, sum[j]);
        }
        Arrays.sort(total);
        // 탐색
        for(int j = 0; j < N; j++){
            int last_index = binary_search(total, total[j].score);
            int rank = N - last_index + 1;

            result[total[j].index][3] = rank;
        }
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < N; j++){
                sb.append(result[j][i]).append(" ");
            }  
            sb.append("\n");
        }              
        System.out.print(sb);
    }
    public static int binary_search(Rank[] arr, int target){
        int start = 0;
        int end = arr.length -1;
        int mid;
        while(start <= end){
            mid = (start + end) / 2;
            if(target < arr[mid].score) {
                end = mid -1;
            } else {
                start = mid + 1;
            }
        } 
        return start;
    }
}
