import java.util.*;

class Solution {
    public static String[] answer = {};

    public String[] solution(String[][] tickets) {

        HashMap<String,PriorityQueue<String>> hash = new HashMap<>();

        for(String[] ticket: tickets){
            if(hash.containsKey(ticket[0])){
                hash.get(ticket[0]).add(ticket[1]);

            }
            else{
                PriorityQueue<String> list = new PriorityQueue<>();
                list.add(ticket[1]);
                hash.put(ticket[0],list);
            }
        }

        answer = new String[tickets.length+1];
        answer[0] = "ICN";

        dfs(hash, "ICN", answer,1);

        return answer;
    }

    public boolean dfs(HashMap<String,PriorityQueue<String>> hash, String start, String[] load,int count){
        if(count == load.length){
            answer = load;
            return true;
        }
        if(!hash.containsKey(start)) return false;
        PriorityQueue<String> nextQueue = new PriorityQueue<>(hash.get(start));

        if(!nextQueue.isEmpty()){
            for(String next: nextQueue){
                hash.get(start).remove(next);
                load[count] = next;
                if(dfs(hash,next,load, count+1)) return true;
                hash.get(start).add(next);
            }

        }

        return false;
    }
}
