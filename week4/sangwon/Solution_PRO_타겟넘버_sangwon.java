class Solution {
    static int cnt = 0;
    
    public void dfs(int[] numbers, int idx, int target, int total){
        if(idx == numbers.length){
            if(total == target) cnt++;
            return;
        }
        
        dfs(numbers, idx+1, target, total+numbers[idx]);
        dfs(numbers, idx+1, target, total-numbers[idx]);             
    }
    
    public int solution(int[] numbers, int target) {        
        dfs(numbers, 0, target, 0);
        return cnt;
    }
}