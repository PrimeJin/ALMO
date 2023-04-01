import java.util.*;
class Solution {
    static int arrLen, strLen;
    static boolean[] check;
    static List<Integer> answerList;  //begin에서 target으로 변환될 수 있는 모든 경우의 수 담는 리스트
    static int answer;
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        arrLen = words.length;  //words 길이 (단어 개수)
        strLen = begin.length();  //단어 길이
        //변환할 수 없는 경우 확인 (target이 배열에 없는 경우)
        List<String> list = Arrays.asList(words);
        if(!list.contains(target)) {
            return 0;
        }
        
        check = new boolean[arrLen];
        answerList = new ArrayList<>();
        dfs(begin, target, words, 0);
        
        Collections.sort(answerList);  //오름차순 정렬
        answer = answerList.get(0);  //경우의 수 중에서 최솟값이 정답
        return answer;
    }
    
    public void dfs(String str, String target, String[] words, int cnt) {
        if(str.equals(target)) {
            System.out.println(cnt);
            answerList.add(cnt);
            return;
        }
        
        for(int i=0; i<arrLen; i++) {
            int tmpCnt = 0;
            for(int j=0; j<strLen; j++) {  //알파벳 몇개 다른지 확인
                if(str.charAt(j) == words[i].charAt(j)) tmpCnt++;        
            }
            
            if(tmpCnt == strLen-1 && !check[i]) {  //한 개의 알파벳만 다르고, 방문한 적이 없을때
                check[i] = true;
                dfs(words[i], target, words, cnt+1);
                check[i] = false;
            }
        }
    }
}