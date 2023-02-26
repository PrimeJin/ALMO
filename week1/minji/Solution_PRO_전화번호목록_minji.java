package week1.minji;
import java.util.*;

public class Solution_PRO_전화번호목록_minji {

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();

        for(String number: phone_book){
            set.add(number);
        }

        for(String number: phone_book){
            for(int i =1;i <number.length();i++){
                if(set.contains(number.substring(0,i))){
                    answer = false;
                    return answer;
                }
            }
        }

        return answer;
    }
}
