import java.util.*;
import java.io.*;

public class Main
{
    public static class jewelry {
        int weight;
        int price;

        public jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Scanner sc = new Scanner(System.in);
      
        int W = Integer.parseInt(st.nextToken()); //배낭의 무게 W
        int N = Integer.parseInt(st.nextToken());//귀금속 종류 N

        jewelry[] jew = new jewelry[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            jew[i] = new jewelry(weight, price);
        }

        //무게당 가격이 높은 순으로 정렬
        Arrays.sort(jew, (o1, o2) -> o2.price - o1.price);

        int idx = 0;   
        int total = 0; //총 가격
        while(W > 0) {
            if(jew[idx].weight >= W) {
                total += W * jew[idx].price;
                break;
            } else {
                total += jew[idx].weight * jew[idx].price;
                W -= jew[idx].weight;
                idx++;
            }
        }

        System.out.println(total);
    }
}