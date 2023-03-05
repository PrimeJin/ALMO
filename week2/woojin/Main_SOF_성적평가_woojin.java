import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());  //참가자 수
        int[][] rank = new int[3][N];  //등수 저장할 배열
        Map<Integer, Integer> totalScore = new HashMap<>();

        //점수 초기화
        for(int i=0; i<3; i++) {
            Score[] scoreArr = new Score[N];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int num = Integer.parseInt(st.nextToken());
                scoreArr[j] = new Score(num, j);  //(점수, 선수) 순서
                totalScore.put(j, totalScore.getOrDefault(j, 0) + num);
            }

            //점수 높은순으로 내림차순 정렬
            int tmp = 0;
            int num = 0;
            Arrays.sort(scoreArr, (o1, o2) -> o2.score - o1.score);

            //대회별 순위 저장
            for(int j=0; j<N; j++) {
                num++;
                if(tmp == scoreArr[j].score) {
                    rank[i][scoreArr[j].idx] = rank[i][scoreArr[j-1].idx];
                } else {
                    rank[i][scoreArr[j].idx] = num;
                }
                tmp = scoreArr[j].score;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int key : totalScore.keySet()) {
            list.add(key);
        }
        Collections.sort(list, (o1, o2) -> totalScore.get(o2) - totalScore.get(o1));  //오름차순 정렬

        //총점 비교
        int tmp = 0;
        int num = 0;
        int[] totalRank = new int[N];
        for(int i=0; i<N; i++) {
            num++;
            if(tmp == totalScore.get(list.get(i))) {
                totalRank[list.get(i)] = totalRank[list.get(i-1)];
            } else {
                totalRank[list.get(i)] = num;
            }
            tmp = totalScore.get(list.get(i));
        }

        //정답 출력
        for(int i=0; i<3; i++) {
            for(int j=0; j<N; j++) {
                sb.append(rank[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for(int i=0; i<N; i++) {
            sb.append(totalRank[i]).append(" ");
        }

        System.out.println(sb);
    }

    static class Score {
        int score;
        int idx;

        public Score(int score, int idx) {
            this.score = score;
            this.idx = idx;
        }
    }
}