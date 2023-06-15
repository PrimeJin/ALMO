import java.lang.*;

class Solution {
    public static String[] answer;

    public String[] solution(int[][] queries) {
        answer = new String[queries.length];

        for(int i=0; i<queries.length;i++){
            int size = (int) Math.pow(4,queries[i][0]-1);
            if(queries[i][0] == 1) answer[i] = "Rr";
            else solution(size, queries[i][1], i);
        }

        return answer;
    }

    public static void solution(int size, int idx, int i){
        if(size == 4){
            if(idx%4 == 1) answer[i] = "RR";
            else if(idx%4 == 0) answer[i] = "rr";
            else answer[i] = "Rr";

            return;
        }

        if(idx <= size/4) answer[i] = "RR";
        else if(idx > size/4*3) answer[i] = "rr";
        else{
            solution(size/4, idx % (size/4), i);
        }

    }
}