import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        int count = Integer.parseInt(bufferedReader.readLine());

        int[] ligthArr = new int[count+1];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        ligthArr[1] = Integer.parseInt(stringTokenizer.nextToken());
        int max=ligthArr[1];

        for (int i = 2; i <= count; i++) {
            ligthArr[i] = Integer.parseInt(stringTokenizer.nextToken());

            int distance = (ligthArr[i]-ligthArr[i-1])/2;
            if((ligthArr[i]-ligthArr[i-1])%2 != 0) distance += 1;
            max = Math.max(max,distance);
        }

        max = Math.max(max,size-ligthArr[count]);

        System.out.println(max);
    }
}
