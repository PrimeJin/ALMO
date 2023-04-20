import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_블로그 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  //시작하고 지난 일 수
        int X = Integer.parseInt(st.nextToken());  //X일 동안 많이 들어온 방문자 수

        int[] visitNum = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            visitNum[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i=0; i<X; i++) {
            sum += visitNum[i];
        }

        int max = sum;  //초기값 설정
        int cnt = 1;  //최대값을 가지는 경우의 수
        for(int i=X; i<N; i++) {
            sum += visitNum[i] - visitNum[i-X];  //새로 나오는 인덱스 더하고 가장이전 인덱스 빼기

            if(max < sum) {
                cnt = 1;
                max = sum;
            } else if(max == sum) {
                cnt++;
            }
        }

        if(max == 0) {
            System.out.print("SAD");
        } else {
            System.out.print(max + "\n" + cnt);
        }

    }
}
