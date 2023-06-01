import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int A,B;
    public static Node nowNode;

    public static class Node{
        char next;
        int n;
        ArrayList<Character> result;


        public Node(char next,int n, ArrayList<Character> result) {
            this.next = next;
            this.n = n;
            this.result = result;
        }
    }
    public static void main(String[] args) throws IOException {
//        3
//        1234 3412
//        1000 1
//        1 16
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            nowNode = null;
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            A = Integer.parseInt(stringTokenizer.nextToken());
            B = Integer.parseInt(stringTokenizer.nextToken());
            boolean[] isvisited = new boolean[10000];

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node('D',A,new ArrayList<>()));
            queue.add(new Node('S',A,new ArrayList<>()));
            queue.add(new Node('L',A,new ArrayList<>()));
            queue.add(new Node('R',A,new ArrayList<>()));

            while(!queue.isEmpty()){
                nowNode = queue.poll();

                if(isRight()) break;
                if(isA()) continue;
                if(isvisited[nowNode.n]) continue;
                isvisited[nowNode.n] = true;

                queue.add(new Node('D', nowNode.n, (ArrayList<Character>) nowNode.result.clone()));
                queue.add(new Node('S', nowNode.n, (ArrayList<Character>) nowNode.result.clone()));
                queue.add(new Node('L', nowNode.n, (ArrayList<Character>) nowNode.result.clone()));
                queue.add(new Node('R', nowNode.n, (ArrayList<Character>) nowNode.result.clone()));
            }

            StringBuilder stringBuilder = new StringBuilder();
            for(char result: nowNode.result){
                stringBuilder.append(result);
            }

            System.out.println(stringBuilder);
        }
    }

    private static boolean isA() {
        if(nowNode.n != A) return false;
        else return true;
    }

    private static boolean isRight() {
        if(nowNode.next == 'D'){
            nowNode.n = (nowNode.n * 2)%10000;
            nowNode.result.add('D');
        }
        else if (nowNode.next == 'S') {
            if(nowNode.n == 0) nowNode.n = 9999;
            else nowNode.n -= 1;
            nowNode.result.add('S');
        }
        else if (nowNode.next == 'L') {
            int n = ((nowNode.n%1000)*10)+(nowNode.n/1000);
            nowNode.n = n;
            nowNode.result.add('L');
        }
        else if (nowNode.next == 'R') {
            int n = (nowNode.n/10)+((nowNode.n%10)*1000);
            nowNode.n = n;
            nowNode.result.add('R');
        }
        if(nowNode.n == B) return true;

        else return false;
    }
}
