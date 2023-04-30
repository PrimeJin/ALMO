import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //    5 2
//    1 4 2 5 1
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int X = Integer.parseInt(stringTokenizer.nextToken());

        int[] totalDayArr = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            totalDayArr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int result = 0;
        int periodCount=1;

        for (int j = 0; j < X; j++) {
            result += totalDayArr[j];
        }

        int count=result;
        for (int i = X; i < N; i++) {
            count -= totalDayArr[i-X];
            count += totalDayArr[i];

            if(result == count){
                periodCount++;
            } else if (result < count) {
                result = count;
                periodCount = 1;
            }
        }
        if(result == 0){
            System.out.println("SAD");
            return;
        }

        System.out.println(result);
        System.out.println(periodCount);

    }
}

