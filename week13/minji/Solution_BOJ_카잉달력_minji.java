import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static int M;
    public static int N;
    public static int x;
    public static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            M = Integer.parseInt(stringTokenizer.nextToken());
            N = Integer.parseInt(stringTokenizer.nextToken());
            x = Integer.parseInt(stringTokenizer.nextToken());
            y = Integer.parseInt(stringTokenizer.nextToken());

            HashSet<Integer> hash = new HashSet<>();
            int result = -1;
            int number=1;

            for (int j = Math.min(M,N); j > 0; j--) {
                if(M % j == 0 && N % j == 0){
                    number = M * (N/j);
                    break;
                }
            }

            for(int j=0; j<number/Math.min(M,N);j++){
                int day = M*j+x;
                if(hash.contains(day)){
                    result = day;
                    break;
                }
                hash.add(day);

                day = N*j+y;
                if(hash.contains(day)){
                    result = day;
                    break;
                }
                hash.add(day);
            }

            stringBuilder.append(result).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
