import java.util.*;
import java.io.*;

public class Solution_BOJ_문자열폭발_sangwon {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine(); //원본 문자열
		String bomb = br.readLine(); //폭발 문자열

		//폭발 문자열을 없애고 남은 문자열을 담을 스택
		Stack<Character> stack = new Stack<>();
		
		//결과값을 정리할 StringBuilder
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			stack.push(c);
			
			//스택에 쌓인 문자열의 길이가 bomb 이상이 됐을 경우
			if(stack.size() >= bomb.length()) {
				boolean check = false;
				//스택에서 bomb 길이만큼 꺼내 bomb 문자열이 만들어지는지 확인
				for(int j=0; j<bomb.length(); j++) {
					if(stack.get(stack.size() - bomb.length() + j) == bomb.charAt(j)) continue;
					else {
						check = true;
						break;
					}
				}
				//check = false라면 bomb이 만들어진것
				if(!check) {
					for(int j=0; j<bomb.length(); j++) stack.pop();
				}
			}
		}
		
		//스택쌓는 작업이 끝났으면 꺼내서 확인
		for(int i=0; i<stack.size(); i++) sb.append(stack.get(i));
		
		if(sb.length() == 0) System.out.println("FRULA");
		else System.out.println(sb);
	}

}
