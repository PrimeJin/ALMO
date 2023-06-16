import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = br.readLine();
        String key = br.readLine();

        char[][] board = new char[5][5];
        boolean[] check = new boolean[26];
        check[9] = true;  //J 없는거 취급
        
        //18~44 board 채우기 시작
        int idx = 0;
        for(int i=0; i<key.length(); i++) {
            char tmp = key.charAt(i);

            if(!check[tmp - 'A']) {
                check[tmp - 'A'] = true;
                int y = idx/5;
                int x = idx%5;
                board[y][x] = tmp;
                idx++;
            } else {
                continue;
            }
        }

        for(int i=idx; i<26; i++) {
            for(int j=0; j<26; j++) {
                if(!check[j]) {
                    int y = i/5;
                    int x = i%5;

                    board[y][x] = (char)(j+'A');
                    check[j] = true;
                    break;
                }
            }
        }
        //board 채우기 끝

        //board 출력해보기
        // for(int i=0; i<5; i++) {
        //     for(int j=0; j<5; j++) {
        //         System.out.print(board[i][j]);
        //     }
        //     System.out.println();
        // }

        //메세지 두글자씩 나누기
        for(int i=0; i<message.length()-1; i++) {
            int nowCh = message.charAt(i);
            int nextCh = message.charAt(i+1);

        }

        int mIdx = 0;
        int mLen = message.length();

        StringBuilder newSb = new StringBuilder();  //2글자씩 나눠서 쌍파괴 작업 수행한 결과
        //2글자씩 나눠서 쌍파괴 작업진행
        while(true) {
            if(mIdx == mLen-1) {
                newSb.append(message.charAt(mIdx));
                newSb.append("X");
                break;
            } else if(mIdx == mLen || mIdx == mLen+1) {
                break;
            }

            char nowCh = message.charAt(mIdx);
            char nextCh = message.charAt(mIdx+1);

            if(nowCh == nextCh) {
                if(nowCh == 'X') {
                    newSb.append(nowCh);
                    newSb.append("Q");
                    // newStr += nextCh;
                } else {
                    newSb.append(nowCh);
                    newSb.append("X");
                    // newStr += nextCh;
                }
                mIdx++;
            } else {
                newSb.append(nowCh);
                newSb.append(nextCh);
                mIdx += 2;
            }
        }
        String newStr = newSb.toString();  //쌍파괴한 결과 문자열

        StringBuilder answerSb = new StringBuilder();  //암호화된 결과
        for(int i=0; i<newStr.length()-1; i+=2) {
            char nowCh = newStr.charAt(i);
            char nextCh = newStr.charAt(i+1);

            int nowR = 0, nowC = 0;
            int nextR = 0, nextC = 0;
            for(int j=0; j<5; j++) {
                for(int k=0; k<5; k++) {
                    if(board[j][k] == nowCh) {
                        nowR = j;
                        nowC = k;
                    }
                    if(board[j][k] == nextCh) {
                        nextR = j;
                        nextC = k;
                    }    
                }
            }

            if(nowR == nextR) {  //두 알파벳이 같은 행에 있을 때
                answerSb.append(board[nowR][(nowC+1)%5]);
                answerSb.append(board[nextR][(nextC+1)%5]);
            } else if(nowC == nextC) {  //두 알파벳이 같은 열에 있을 때
                answerSb.append(board[(nowR+1)%5][nowC]);
                answerSb.append(board[(nextR+1)%5][nextC]);
            } else {  //서로 다른 행과 열에 있을 때 열값 바꾸기
                answerSb.append(board[nowR][nextC]);
                answerSb.append(board[nextR][nowC]);
            }
        }
        
        System.out.print(answerSb.toString());
    }
}