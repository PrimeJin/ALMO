import java.util.*;

class Solution {
    public int solution(int[] ability, int number) {
        int answer = 0;
        int size = ability.length;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0; i<size; i++){
            queue.add(ability[i]);
        }

        for(int i=0; i<number; i++){
            int em1 = queue.poll();
            int em2 = queue.poll();
            queue.add(em1 + em2);
            queue.add(em1 + em2);
        }

        for(int i=0; i<size; i++){
            answer += queue.poll();
        }

        return answer;
    }
}