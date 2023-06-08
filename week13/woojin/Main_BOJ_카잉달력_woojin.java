import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());  //테스트케이스 개수

        StringBuilder sb = new StringBuilder();
        for(int test_case = 0; test_case<T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            //얘네가 몇번째 해인지
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int cnt = 1;
            int a = 1;
            int b = 1;

            int lcm = 1;  //최소공배수
            int gcd = 1;  //최대공약수
            int min = Math.min(M, N);
            int max = Math.max(M, N);
            for(int i = min; i>=2; i--) {
                if(min%i == 0 && max%i == 0) {
                    gcd = i;
                    break;
                }
            }
            
            lcm = gcd * (M/gcd) * (N/gcd);  //최소공배수

            //초기 M일때 구하기
            while(true) {
                if(a == x) {
                    break;
                }

                if(a < M) {
                    a++;
                } else {
                    a = 1;
                }

                if(b < N) {
                    b++;
                } else {
                    b = 1;
                }

                cnt++;
            }

            while(true) {
                if(b == y) {
                    break;
                }

                if(cnt > lcm) {
                    cnt = -1;  //유효하지 않은 표현이면 -1 출력
                    break;
                }

                if(b + M > N) {
                    b = (b + M) % N;
                    if(b == 0) b=N;
                } else {
                    b += M;
                }

                cnt += M;
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}
