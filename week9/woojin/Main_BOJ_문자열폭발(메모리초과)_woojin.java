import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String answer = "FRULA";  //남아있는 문자가 없는 경우 답
        String bomb = br.readLine();

        while(true) {
            if(!str.contains(bomb)) break;
            String[] strArr = str.split(bomb);
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<strArr.length; i++) {
                sb.append(strArr[i]);
            }

            str = sb.toString();
        }

        System.out.println(str.equals("")?answer:str);
    }
}
