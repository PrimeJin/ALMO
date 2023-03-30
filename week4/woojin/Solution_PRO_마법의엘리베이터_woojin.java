import java.util.*;
class Solution {
    static int[] numArr;
    // static boolean[] check;
    static int cnt;
    public int solution(int storey) {
        int answer = 0;
        String str = "" + storey;
        
        int n = 0;
        if(str.charAt(0) > 4) {
            n = str.length() + 1;
        } else {
            n = str.length();
        }
        
        boolean[] check = new boolean[100000001];
        numArr = new int[n*2];
        int idx = 0;
        for(int i=0; i<n; i++) {
            numArr[idx] = (-1) * (int)Math.pow(10, i);
            idx++;
            numArr[idx] = (int)Math.pow(10, i);
            idx++;
        }
        
        cnt = 0;
        bfs(storey, check);
        
        return cnt;
    }
    
    public void bfs(int floor, boolean[] check) {
        Queue<Integer> queue = new ArrayDeque();
        queue.offer(floor);
        check[floor] = true;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                
                int cur = queue.poll();
                if(cur == 0) {
                    return;
                }
                for(int j=0; j<numArr.length; j++) {
                    int tmpNum = cur + numArr[j];
                    if(tmpNum >= 0 && tmpNum < check.length && !check[tmpNum]) {
                        queue.offer(tmpNum);
                        check[tmpNum] = true;
                    // cnt++;
                    }
                }
            }
            cnt++;
        }
        
    }
}