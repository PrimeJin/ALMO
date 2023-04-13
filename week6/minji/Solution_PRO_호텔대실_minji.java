import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;

        int[][] time = new int[book_time.length][2];
        for(int i=0;i<book_time.length;i++){
            StringTokenizer st = new StringTokenizer(book_time[i][0],":");
            time[i][0] = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
            st = new StringTokenizer(book_time[i][1],":");
            time[i][1] = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken()) +10;
        }
        Arrays.sort(time,(a,b) -> a[0] - b[0]);

        LinkedList<Integer> list = new LinkedList<>();
        list.add(time[0][1]);

        for(int i=1;i<time.length;i++){
            boolean isBooked = false;
            for(int j=0,size=list.size(); j<size;j++){
                if(list.get(j) <= time[i][0]) {
                    list.remove(j);
                    list.add(j,time[i][1]);
                    isBooked = true;
                    break;
                }
            }
            if(!isBooked){
                list.add(time[i][1]);
            }
        }

        answer = list.size();

        return answer;
    }
}