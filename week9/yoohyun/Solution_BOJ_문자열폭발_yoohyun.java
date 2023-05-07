import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();
		int lastIdx = bomb.length - 1;
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < input.length; i++) {
			stack.add(input[i]);
			if(input[i] == bomb[lastIdx]) {
				check(bomb, stack);
			}
		}
		if(stack.isEmpty()) System.out.println("FRULA");
		else {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < stack.size(); i++) {
				sb.append(stack.get(i));
			}
			System.out.println(String.valueOf(sb));
		}
    }
	public static void check(char[] bomb, Stack<Character> s) {
		Stack<Character> tmp = new Stack<>();
		boolean isTrue = true;
		for(int j = bomb.length - 1; j >=0 ; j--) {
			if(s.isEmpty()) {
				isTrue = false;
				break;
			}
			if(s.peek() != bomb[j]) {
				isTrue = false;
				break;
			}
			tmp.add(s.pop());
		}
		if(!isTrue) {
			while(!tmp.isEmpty()) {
				s.add(tmp.pop());
			}
		}
	}
}
