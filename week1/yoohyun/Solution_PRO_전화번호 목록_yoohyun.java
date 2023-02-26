import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String phone: phone_book){
            map.put(phone, phone.length());
        }
        
        for(int i = 0; i < phone_book.length; i++){
            for(int j = 0; j < map.get(phone_book[i]); j++){
                if(map.containsKey(phone_book[i].substring(0, j))){
                    return false;
                }
            }
        }
        return answer;
    }
}
