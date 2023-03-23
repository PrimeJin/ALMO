import java.util.*;

class Solution {    
    public int solution(int storey) {  
        //각 자릿수를 분리해서 넣어둘 큐
        Queue<Integer> digit = new LinkedList<>();
        
        //굳이 num 안만들어도됨..
        int num = storey; 
        while(num / 10 > 0){
            digit.add(num%10);
            num /= 10;
        }
        //마지막(맨 왼쪽 자릿수)은 따로 체크
        int last = num;
        digit.add(last);
        
        int cnt = 0; //마법의 돌 사용 횟수
        int temp = 0; //반올림할 때 올리는 수
        boolean five = false; //이전 자릿수가 5인지 체크하는 불값
        while(!digit.isEmpty()){
            int d = digit.poll(); //각 자릿수에 해당하는 숫자 추출
            
            //이전 숫자가 5였으면 올림해서 이득보는지
            //0, 1, 2, 3, 4의 경우 자릿수 올려도 손해
            if(d < 5 && five) temp = 0; 
            if(d >= 5 && five) temp = 1;
            
            d += temp;
            //내림해서 이득보는 경우
            if(d < 5) {
                cnt += d;
                temp = 0;
                five = false;
            }
            //올림해서 이득보는 경우
            else if(d > 5){ 
                cnt += 10-d;
                temp = 1;
                five = false;
            }
            //d == 5
            else {
                cnt += 5;
                five = true;              
            }
        }
        
        //맨 왼쪽자리 수 체크
        if(last + temp >= 6) cnt++;
        return cnt;
    }
}