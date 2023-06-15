import java.util.*;
import java.io.*;
import java.awt.*;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        String key = bufferedReader.readLine();
        char[][] map = new char[5][5];
        HashSet<Character> hash = new HashSet<>();

        //map 생성
        for(char spell:key.toCharArray()){
            if(!hash.contains(spell)){
                map[hash.size()/5][hash.size()%5] = spell;
                hash.add(spell);

            }
        }

        for(int i=0; i<26; i++){
            char spell = (char)('A'+i);
            if(spell != 'J' && !hash.contains(spell)){
                map[hash.size()/5][hash.size()%5] = spell;
                hash.add(spell);
            }
        }

        //input 나누기
        ArrayList<char[]> inputArr = new ArrayList<>();
        char[] inputToChar = input.toCharArray();
        int index=0;

        while(index < inputToChar.length){
            char[] couple = new char[2];

            char one = inputToChar[index++];
            char two = ' ';

            if(index == inputToChar.length){
                two = 'X';
            }else{
                two = inputToChar[index];

                if(one == two){
                    if(one == 'X'){
                        two = 'Q';
                    }else{
                        two = 'X';
                    }
                }else{
                    index++;
                }
            }

            couple[0] = one;
            couple[1] = two;
            inputArr.add(couple);
        }

        //암호화
        StringBuilder stringBuilder = new StringBuilder();
        for(char[] couple: inputArr){
            Point one = new Point();
            Point two = new Point();
            int num = number(couple,map,one,two);

            if(num == 1){
                one.y = (one.y+1)%5;
                two.y = (two.y+1)%5;
                stringBuilder.append(Character.toString(map[one.x][one.y]))
                        .append(Character.toString(map[two.x][two.y]));
            }
            else if(num == 2){
                one.x = (one.x+1)%5;
                two.x = (two.x+1)%5;
                stringBuilder.append(Character.toString(map[one.x][one.y]))
                        .append(Character.toString(map[two.x][two.y]));
            }
            else{
                int tmp = one.y;
                one.y = two.y;
                two.y = tmp;
                stringBuilder.append(Character.toString(map[one.x][one.y]))
                        .append(Character.toString(map[two.x][two.y]));
            }
        }

        System.out.println(stringBuilder);
    }

    public static int number(char[] couple, char[][] map, Point one, Point two){
        for(int i=0; i<5; i++){
            for(int j=0; j<5;j++){
                if(map[i][j] == couple[0]){
                    one.x = i;
                    one.y = j;
                }
                if(map[i][j] == couple[1]){
                    two.x = i;
                    two.y = j;
                }
            }
        }

        if(one.x == two.x) return 1;
        else if(one.y == two.y) return 2;
        else return 3;
    }
}