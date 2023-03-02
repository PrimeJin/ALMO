import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());  //배낭 무게
        int N = Integer.parseInt(st.nextToken());  //귀금속 종류
        
        Price[] priceArr = new Price[N];  //금속의 무게당 가격
        //금속 무게와 무게당 가격 초기화
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int tmpWeight = Integer.parseInt(st.nextToken());
            int tmpPrice = Integer.parseInt(st.nextToken());

            priceArr[i] = new Price(tmpWeight, tmpPrice);
        }

        //priceArr 배열 내림차순 정렬
        Arrays.sort(priceArr, (o1, o2) -> o2.price - o1.price );

        int answer = 0;
        int sum = 0;
        label1: for(int i=0; i<N; i++) {
            for(int j=1; j<=priceArr[i].weight; j++) {
                if(sum == W) {
                    break label1;
                } else {
                    sum += 1;
                    answer += priceArr[i].price;
                }
            }   
        }
        System.out.println(answer);
    }

    static class Price {
        int weight;
        int price;

        public Price(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }
}