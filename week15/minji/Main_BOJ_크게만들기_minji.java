import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main
{    public static void main(String args[]) throws Exception
{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int N = Integer.parseInt(stringTokenizer.nextToken());
    int K = Integer.parseInt(stringTokenizer.nextToken());
    char[] numChar = bufferedReader.readLine().toCharArray();
    Stack<Integer> stack = new Stack<>();
    stack.add(numChar[0]-'0');
    int count=0;

    for (int i = 1; i < N; i++) {
        int now = numChar[i]-'0';
        while (count < K && !stack.isEmpty() && stack.peek() < now){
            stack.pop();
            count++;
        }

        stack.add(now);
    }

    StringBuilder stringBuilder = new StringBuilder();
    count = N-K;
    for (Object number : stack.toArray()) {
        if(count == 0) break;
        stringBuilder.append(number.toString());
        count--;
    }

    System.out.println(stringBuilder);
}
}
