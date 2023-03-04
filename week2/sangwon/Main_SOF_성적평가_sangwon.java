import java.util.*;
import java.io.*;


public class Main
{
    static int N;
    static StringBuilder sb = new StringBuilder();

    static class Part {
        int score;
        int idx;
        int rank;

        public Part(int score, int idx) {
            this.score = score;
            this.idx = idx;
            this.rank = 1; //1위로 고정
        }
    }

    public static void partSort(Part[] part) {
        //score높은 순으로 정렬
        Arrays.sort(part, (o1, o2) -> o2.score - o1.score);
            
        for(int i=1; i<N; i++){
            if(part[i].score == part[i-1].score) part[i].rank = part[i-1].rank; //이전 참가자와 스코어가 같은 경우만 동점으로 분류
            else part[i].rank = i+1; //이미 score순으로 정렬되어 있으므로 i+1이 등수
        }

        Arrays.sort(part, (o1, o2) -> o1.idx - o2.idx);
        for(int i=0; i<N; i++){
            sb.append(part[i].rank).append(" ");
        }
        sb.append("\n");
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());     //참가자 수
        //참가자 전체 순위를 정하기 위한 배열
        Part[] totalp = new Part[N]; 
        int[] total = new int[N]; //전체 대회 score만 담은 배열

        for(int n=0; n<3; n++){
            String str = br.readLine();
            String[] arr = str.split(" ");
            Part[] part = new Part[N];
            for(int i=0; i<N; i++){
                part[i] = new Part(Integer.parseInt(arr[i]), i);
                total[i] += Integer.parseInt(arr[i]);
            }
            partSort(part);
        }

        for(int i=0; i<N; i++){
            totalp[i] = new Part(total[i], i);
        }
        partSort(totalp);
        
        System.out.print(sb);
    }
}