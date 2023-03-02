import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        String answer = "";
        if(A>B) {
            answer = "A";
        } else if(A<B) {
            answer = "B";
        } else {
            answer = "same";
        }

        System.out.println(answer);
        
    }
}