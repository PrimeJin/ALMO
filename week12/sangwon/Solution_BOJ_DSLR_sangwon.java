import java.util.*;

public class Main {
	static int min;
	static String ans = "";
	static boolean[] visited;
	
	
	static int Double(int n) {
		if(2*n > 9999) return (2*n)%10000;
		return 2*n;
	}
	
	static int Subsequence(int n) {
		if(n == 0) return 9999;
		return n-1;
	}
	
	static int LeftShift(int n) {
		int d1 = n/1000;
		int d2 = (n - d1*1000)/100;
		int d3 = (n - d1*1000 - d2*100)/10;
		int d4 = n - d1*1000 - d2*100 - d3*10;
		
		return d2*1000 + d3*100 + d4*10 + d1;
	}
	
	static int RightShift(int n) {
		int d1 = n/1000;
		int d2 = (n - d1*1000)/100;
		int d3 = (n - d1*1000 - d2*100)/10;
		int d4 = n - d1*1000 - d2*100 - d3*10;
		
		return d4*1000 + d1*100 + d2*10 + d3;
	}
	
	
	static class Node {
		int value;
		String str;
		
		public Node(int value, String str) {
			this.value = value;
			this.str = str;
		}
	}
	
	static void bfs(int st, int ed) {
		Queue<Node> q = new LinkedList<>();
		
		q.add(new Node(st, ""));
		visited[st] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int v = n.value;
			String s = n.str;

			if(v == ed) {
				ans = s;
				return;
			}
			
			if(!visited[Double(v)]) {
				visited[Double(v)] = true;
				q.add(new Node(Double(v), s + "D"));
			}
			if(!visited[Subsequence(v)]) {
				visited[Subsequence(v)] = true;
				q.add(new Node(Subsequence(v), s + "S"));
			}
			if(!visited[LeftShift(v)]) {
				visited[LeftShift(v)] = true;
				q.add(new Node(LeftShift(v), s + "L"));
			}
			if(!visited[RightShift(v)]) {
				visited[RightShift(v)] = true;
				q.add(new Node(RightShift(v), s + "R"));
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //test case
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			min = Integer.MAX_VALUE;
			visited = new boolean[10000];
			
			int a = sc.nextInt(); //초기값 A
			int b = sc.nextInt(); //최종값 B
			
			bfs(a, b);
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}

}
