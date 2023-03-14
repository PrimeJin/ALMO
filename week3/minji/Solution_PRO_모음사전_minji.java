class Solution {
    private static int count=0;

    public int solution(String word) {
        int answer = 0;
        char[] wordArr = word.toCharArray();
        char[] compareArr = new char[5];
        char[] decArr = {'A','E','I','O','U'};

        dfs(wordArr,compareArr,decArr,0);

        answer = count;

        return answer;
    }
    public boolean dfs(char[] wordArr, char[] compareArr,char[] decArr,int index){
        if(index == 5){
            return false;
        }
        for(int i=0;i < 5;i++){
            count++;
            char[] copyCompareArr = compareArr.clone();
            copyCompareArr[index] = decArr[i];
            if(compare(wordArr,copyCompareArr)) return true;

            if(dfs(wordArr,copyCompareArr,decArr,index+1)){
                return true;
            }
        }
        return false;
    }

    public boolean compare(char[] wordArr, char[] compareArr){
        for(int i=0;i < wordArr.length;i++){
            if(wordArr[i] != compareArr[i]) return false;
        }
        return true;
    }

}
