import java.util.*;
import java.io.*;

public class Solution_BOJ_������_sangwon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt(); //������ ����

        //�������� ����
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
        	if(Math.abs(o1) > Math.abs(o2)) return 1;
        	else if(Math.abs(o1) < Math.abs(o2)) return -1;
        	else {
        		return o1 - o2;
        	}
        });

        for(int i=0; i<N; i++){
            int input = sc.nextInt();

            if(input == 0) {
                if(q.isEmpty()) sb.append(0).append("\n");
                else sb.append(q.poll()).append("\n");
            } else {
                q.add(input);
            }
        }

        System.out.println(sb);
    }
}
