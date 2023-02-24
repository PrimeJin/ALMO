/*
    접두어만 비교하면 되기 때문에 substring()을 사용해주었다
    대신 substring(i) 이런식으로 사용하면 빈 배열을 만들 수 있기 때문에 주의
    substring(0, i) => 0~i-1까지 자름
*/

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        //중복된 번호가 없기 때문에 HashSet을 써도 사라질 데이터는 없고
        //대신 contains()로 원하는 데이터가 있는지 바로 찾을 수 있다
        HashSet<String> set = new HashSet<String>();
        
        //모든 전화번호를 앞에서부터 한자리씩 끊으면서 HashSet에 저장했다
        for(int i=0; i<phone_book.length; i++){
            for(int j=0; j<phone_book[i].length(); j++){
                set.add(phone_book[i].substring(0, j));
            }
        }
        
        //전화번호 중에 접두어 set에 저장된 값과 겹치는 게 있는지 확인한다
        for(int i=0; i<phone_book.length; i++){
            if(set.contains(phone_book[i])) return false;
        }
        
        return answer;
    }
}