import java.io.*;
import java.util.Stack;

public class Main_BOJ_문자열폭발2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String bomb = br.readLine();
        int bombLen = bomb.length();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            stack.push(str.charAt(i));

            if(stack.size() >= bombLen) {  //폭탄 문자열 길이 이상일 때부터 비교
                boolean flag = true;
                for(int j=stack.size()-1; j>stack.size()-1-bombLen; j--) {
                    if(stack.get(j) != bomb.charAt(bombLen + j - stack.size())) {  //비교하다가 같지 않다는걸 판별하면 flag=false로 바꾸고 탈출
                        flag = false;
                        break;
                    }
                }

                if(flag) {  //폭탄 문자열 제거
                    for(int j=0; j<bombLen; j++) {
                        stack.pop();
                    }
                }
            }
        }

        //제거 후 문자열 sb에 추가
        for(int i=0; i<stack.size(); i++) {
            sb.append(stack.get(i));
        }

        bw.write(sb.toString().equals("")?"FRULA":sb.toString());  //남아있는 문자가 없으면 FRULA 출력
        bw.flush();
        bw.close();
    }
}
