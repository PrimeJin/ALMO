import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        char[] stringToChar = string.toCharArray();
        String bomb = bufferedReader.readLine();
        char[] bombToChar = bomb.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        Deque<Character> deque = new LinkedList<>();

        for (char nowChar:stringToChar) {
            stringBuilder.append(nowChar);

            int bombSize = bombToChar.length;
            if(stringBuilder.length() >= bombSize){
                String compare = stringBuilder.substring(stringBuilder.length()-bombSize,stringBuilder.length());
                if(compare.equals(bomb)) stringBuilder.delete(stringBuilder.length()-bombSize,stringBuilder.length());
            }
        }
        if(stringBuilder.length() == 0) stringBuilder.append("FRULA");
        System.out.println(stringBuilder);
    }
}
