import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        5
//        -99 -2 -1 4 98
//        -99 -2 -1 4 55 63 98
//
//        3 2 95

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());

        int[] liquid = new int[size];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < size; i++) {
            liquid[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        StringBuilder stringBuilder = new StringBuilder();
        int point1 = 0;
        int point2 = size-1;
        int min = Integer.MAX_VALUE;
        int result1 = liquid[point1];
        int result2 = liquid[point2];

        while(point1 != point2){
            int num = liquid[point1]+liquid[point2];
            if(min > Math.abs(num)){
                min = Math.abs(num);
                result1 = liquid[point1];
                result2 = liquid[point2];
            }
            if(num > 0){
                point2--;
            } else if (num < 0) {
                point1++;
            }else{
                break;
            }
        }

        stringBuilder.append(result1).append(" ").append(result2);
        System.out.println(stringBuilder);

    }
}
