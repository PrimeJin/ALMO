import java.util.*;

class Solution {
    public String solution(String input_string) {
        int size = input_string.length();
        
        boolean[] check = new boolean[26];
        for(int i=0; i<size; i++) {
            int aIdx = input_string.charAt(i) - 'a';
            if(check[aIdx]) continue;  //이미 외톨이 알파벳이면 넘김
            
            boolean depart = false;
            for(int j=i+1; j<size; j++) {
                int compareIdx = input_string.charAt(j) - 'a';
                
                if(depart && aIdx == compareIdx) {  //찢어진적이 있고 다시 등장한거면
                    check[aIdx] = true;
                    break;
                }
                
                if(aIdx != compareIdx) {
                    depart = true;
                } 
                
            }
        }
        
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i=0; i<26; i++) {
            if(check[i]) {
                flag = true;
                sb.append((char)(i + 'a'));
            }
        }
        
        if(!flag) return "N";
        
        return sb.toString();
    }
    
}