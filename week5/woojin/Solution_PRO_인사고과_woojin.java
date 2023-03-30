import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int len = scores.length;  //사람수    
        
        int a = scores[0][0];
        int b = scores[0][1];
        //완호가 다른 애들보다 두 점수 모두 낮은 경우 체크
        for(int i=1; i<len; i++) {
            if(scores[i][0] > a && scores[i][1] > b) {
                return -1;
            }
        }
        
        int[] sumArr = new int[len];
        for(int i=0; i<len; i++) {
            sumArr[i] += scores[i][0];
            sumArr[i] += scores[i][1];
        }
        
        Idx[] idxArr = new Idx[len];
        for(int i=0; i<len; i++) {
            idxArr[i] = new Idx(scores[i][0], scores[i][1], i);
        }
        
        //일단 합이 원호보다 작은애는 제외
        boolean[] check = new boolean[len];
        for(int i=1; i<len; i++) {
            if(sumArr[i] < sumArr[0]) {
                check[i] = true;
            }
        }
        
        Arrays.sort(idxArr, (o1,o2) -> o1.a==o2.a? (o1.b-o2.b) : o1.a-o2.a);  //근무태도점수(a)오름차순 정렬, a가 같을 때는 동료평가점수(b) 오름차순 정렬
        for(int i=0; i<len; i++) {
            int tmpA = idxArr[i].a;
            int tmpB = idxArr[i].b;
            int tmpIdx = idxArr[i].idx;
            if(!check[tmpIdx]) {
                for(int j=i+1; j<len; j++) {
                    if(tmpA < idxArr[j].a && tmpB < idxArr[j].b) {
                        check[tmpIdx] = true;
                        break;
                    }
                
                }
            }
            
        }
        
        int answer = 1;
        for(int i=1; i<sumArr.length; i++) {
            if(sumArr[i] > sumArr[0] && !check[i] ) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public class Idx {
        int a;
        int b;
        int idx;
        
        public Idx(int a, int b, int idx) {
            this.a = a;
            this.b = b;
            this.idx = idx;
        }
    }
}
//5 5
//4 4
//1 6