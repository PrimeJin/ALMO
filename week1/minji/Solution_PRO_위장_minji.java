package week1.minji;
import java.util.*;
import java.awt.*;

public class Solution_PRO_위장_minji {
//    class Solution {
    private static int result =0;
    private static String[][] clothesCopy;

    public int solution(String[][] clothes) {
            clothesCopy = clothes;
            HashMap<String,String> choosed = new HashMap<>();

            for(int i=1; i <= clothes.length; i++){
                dfs(i, 0, 0, choosed);
            }

            int answer = result;

            return answer;
        }

        public static void dfs(int max, int count,int index, HashMap<String,String> choosed){
            if(count == max && choosed.size() == max){
                result++;
                return;
            }

            for(int i=index; i<clothesCopy.length; i++){
                HashMap<String,String> copyChoosed = (HashMap<String, String>) choosed.clone();
                copyChoosed.put(clothesCopy[i][1],clothesCopy[i][0]);
                dfs(max, count+1, index+1, copyChoosed);
                dfs(max, count, index+1, choosed);
            }
        }
//    }
}
