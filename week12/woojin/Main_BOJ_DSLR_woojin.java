import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int A, B;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            check = new boolean[10000];
            String answer = bfs(A);

            char[] chArr = answer.toCharArray();
            for(int j=0; j<answer.length(); j++) {
                if(answer.charAt(j) == '0') {
                    chArr[j] = 'D';
                } else if(answer.charAt(j) == '1') {
                    chArr[j] = 'S';
                } else if(answer.charAt(j) == '2') {
                    chArr[j] = 'L';
                } else if(answer.charAt(j) == '3') {
                    chArr[j] = 'R';
                }
            }

            for(int j=0; j<chArr.length; j++) {
                sb.append(chArr[j]);
            }

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static String bfs(int num) {
        Queue<Command> queue = new ArrayDeque<>();
        queue.offer(new Command(num, ""));
        check[num] = true;

        while(!queue.isEmpty()) {
            Command cur = queue.poll();
            if(cur.value == B) {
                return cur.cmd;
            }

            for(int j=0; j<4; j++) {
                int result = dslr(j, cur.value);
                if(!check[result]) {
                    check[result] = true;
                    queue.offer(new Command(result, cur.cmd + j));
                }
            }
        }
        return "";
    }

    static class Command {
        int value;  //명령처리 결과
        String cmd;  //지금까지 입력된 명령어

        public Command(int value, String cmd) {
            this.value = value;
            this.cmd = cmd;
        }
    }

    public static int dslr(int idx, int num) {  //dslr 명령 처리

        if (idx == 0) {
            return 2 * num > 9999 ? ((2 * num) % 10000) : 2 * num;
        } else if (idx == 1) {
            return num == 0 ? 9999 : num - 1;
        } else if (idx == 2) {
            int tmp = 0;
            tmp += num%1000 * 10;
            tmp += num/1000;
            return tmp;
        } else if (idx == 3) {
            int tmp = 0;
            tmp += (num%10) * 1000;
            tmp += num/10;
            return tmp;
        }
        return 0;
    }

}