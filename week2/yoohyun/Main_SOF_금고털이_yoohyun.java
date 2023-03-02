import java.util.*;
import java.io.*;


public class Main
{
    public static class Jewelry implements Comparable<Jewelry> {
        int weight;
        int value;

        public Jewelry(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
        public int compareTo(Jewelry o){
              if(this.value < o.value) return 1;
              else if(this.value > o.value) return -1;
              else return 0;
        }
    }
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<Jewelry> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            list.add(new Jewelry(M,V));
        }
        Collections.sort(list);

        int total = 0;
        int result = 0;
        for(Jewelry jewelry: list){
            int weight = jewelry.weight;
            if(W - total >= weight){
                result += (weight * jewelry.value);
                total += weight;
            } else {
                result += (W-total) * jewelry.value;
                break;
            }
        }
        System.out.print(result);
    }
}
