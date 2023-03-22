class Solution {
    private int count;
    private int answer;
    public int solution(String begin, String target, String[] words) {
        answer = 0;

        dfs(begin, target, words,0);

        return answer;
    }

    public void dfs(String begin, String target, String[] words,int index){
        if(begin.equals(target)){
            answer = index;
            return;
        }
        if(index == words.length){
            return;
        }

        for(int i=0; i<words.length;i++){
            if(words[i] != "1" &&compare(begin,words[i])){
                String[] wordsCopy = words.clone();
                wordsCopy[i] = "1";

                dfs(words[i],target, wordsCopy,index+1);
            }
        }
    }

    public boolean compare(String a, String b){
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        int cnt = 0;

        for(int i=0; i < aChar.length;i++){
            if(aChar[i] != bChar[i]) cnt++;
            if(cnt > 1) return false;
        }

        return true;
    }
}