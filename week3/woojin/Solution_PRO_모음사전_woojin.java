class Solution {
    static int answer, cnt;
    static char[] chArr = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        answer = 0;
        cnt = 0;

        dfs("", word);
        
        return answer;
    }
    
    public void dfs(String str, String word) {  //str: 현재 만들어진 문자열, word: 찾는 단어
        if(str.equals(word)) {  //현재 만들어진 str이 찾는 단어랑 같아지면 answer에 cnt(몇번째인지) 넣고 종료
            answer = cnt;
            return;
        }
        
        if(str.length() == 5) {  //문장 길이가 최대값인 5일때는 return처리
            return;
        }
        
        for(int i=0; i<5; i++) {
            cnt++;
            dfs(str + chArr[i], word);
        }
        
        
    }
}