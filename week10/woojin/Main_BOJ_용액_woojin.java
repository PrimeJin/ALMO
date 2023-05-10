import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, rt = N-1;

        int idx1 = 0, idx2 = 0;  //정답 인덱스
        int min = Integer.MAX_VALUE;
        int pre = Integer.MAX_VALUE;  //이전합 저장해놓을 변수
        while (lt<rt) {
            int sum = arr[lt] + arr[rt];  //현재합
            if(pre >= Math.abs(sum)) {
                if(min >= Math.abs(sum)) {
                    idx1 = lt;
                    idx2 = rt;
                    min = Math.abs(sum);
                }

                if(min == 0) break;  //특성값이 0나오는 순간부터는 비교할 필요 없음
            }
            pre = Math.abs(sum);

            if(sum > 0) {
                rt--;
            } else if(sum < 0) {
                lt++;
            }
        }

        System.out.print(arr[idx1] + " " + arr[idx2]);
    }
}
