class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] room = new int[1450];
        
        for(int i=0; i<book_time.length; i++){
            int sh1 = book_time[i][0].charAt(0) - 48;
            int sh2 = book_time[i][0].charAt(1) - 48;
            int sm1 = book_time[i][0].charAt(3) - 48;
            int sm2 = book_time[i][0].charAt(4) - 48;
            int eh1 = book_time[i][1].charAt(0) - 48;
            int eh2 = book_time[i][1].charAt(1) - 48;
            int em1 = book_time[i][1].charAt(3) - 48;
            int em2 = book_time[i][1].charAt(4) - 48;
        
            int st_time = (sh1*10 + sh2)*60 + sm1*10 + sm2;
            int ed_time = (eh1*10 + eh2)*60 + em1*10 + em2;
            
            for(int j = st_time; j < ed_time+10; j++){
                room[j]++;
                if(room[j] > answer) answer = room[j];
            }
        }
        
        
        return answer;
    }
}