class Solution {
    static boolean[] check;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        int len = dungeons.length;
        check = new boolean[len];
        
        dfs(0, k, dungeons);
        return answer;
    }
    
    public void dfs(int cnt, int k, int[][] dungeons) {
        for(int i=0; i<dungeons.length; i++) {
            if(dungeons[i][0] <= k && !check[i]) {
                check[i] = true;
                dfs(cnt+1, k-dungeons[i][1], dungeons);
                check[i] = false;
            }    
        }
        
        answer = Math.max(answer, cnt);
    }
}