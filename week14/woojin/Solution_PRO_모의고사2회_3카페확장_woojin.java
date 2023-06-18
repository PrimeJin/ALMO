import java.util.*;
class Solution {
    public int solution(int[] menu, int[] order, int k) {//menu:제조시간, order:주문음료번호
        int answer = 0;
        int people = order.length;  //총 손님 수
        
        int nowCnt = 0;
        int next = k;
        int now = 0;
        for(int i=0; i<people; i++) {
            now += menu[order[i]];
            if(now < next) {
                now = next;
            }
            next += k;
        }
        
        int lastOrder = now;
        int[] timeArr = new int[lastOrder];
        next = k;
        now = 0;
        int visitTime = 0;
        int lastVisit = k*(people-1);
        for(int i=0; i<people; i++) {
            now += menu[order[i]];  //메뉴 제조 끝나는 시간
            for(int j=visitTime; j<now; j++) {
                timeArr[j]++;
            }
            //다음사람 도착하기전에 제조완료했을 때
            if(now < next) {
                now = next;
            }
            next += k;
            visitTime += k;
        }
        
        Arrays.sort(timeArr);
        answer = timeArr[lastOrder-1];
        
        return answer;
    }
}