import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        
        int len = book_time.length;
        int[][] time = new int[len][2];
        
        int[] roomHour = new int[1450];
        //int[][] 로 바꾸기
        for(int i=0; i<len; i++) {
            int tmpHour = Integer.parseInt(book_time[i][0].substring(0, 2));
            int tmpMin = Integer.parseInt(book_time[i][0].substring(3,5));
            int startTime = tmpHour*60 + tmpMin;  //분으로 바꾸기
            
            tmpHour = Integer.parseInt(book_time[i][1].substring(0, 2));
            tmpMin = Integer.parseInt(book_time[i][1].substring(3,5));
            int endTime = tmpHour*60 + tmpMin;  //분으로 바꾸기
            for(int j=startTime; j<endTime+10; j++) {
                roomHour[j]++;  //방 겹치는 수만큼 +1처리
            }
        }
        
        int max = 0;
        for(int i=0; i<1440; i++) {
            max = Math.max(max, roomHour[i]);
        }
        
        return max;
    }
    
}