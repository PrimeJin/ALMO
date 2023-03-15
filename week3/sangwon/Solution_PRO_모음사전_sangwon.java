/**
 * AAAAA -> AAAAE 1단어
 * AAAAA -> AAAEA 5*1+1 = 6단어
 * AAAAA -> AAEAA 5*6+1 = 31단어
 * AAAAA -> AEAAA 5*31+1 = 156단어
 * AAAAA -> EAAAA 5*156+1 = 781단어 차이
 */

import java.util.*;
import java.io.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        
        int[] plusDigit = { 781, 156, 31, 6, 1 };
        int digit = word.length(); //자릿수에 따라
        
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            
            if(c == 'A') answer += 1;
            else if (c == 'E') answer += plusDigit[i] * 1 + 1;
            else if (c == 'I') answer += plusDigit[i] * 2 + 1;
            else if (c == 'O') answer += plusDigit[i] * 3 + 1;
            else answer += plusDigit[i] * 4 + 1;
        }
                
        
        return answer;
    }
}