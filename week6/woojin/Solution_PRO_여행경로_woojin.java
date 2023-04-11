import java.util.*;
class Solution {
    static boolean[] check;
    static List<String> list;
    static String[] answer;
    static int len;
    public String[] solution(String[][] tickets) {
        len = tickets.length;  //배열 원소 개수
        
        list = new ArrayList<>();
        check = new boolean[len];

        dfs("ICN", "ICN", 0, tickets);  //기본 출발지는 ICN, 기본적으로 path(경로)에 ICN이 첫번째로 추가됨
        Collections.sort(list);
        return list.get(0).split(" ");  //split으로 문자열 잘라서 배열만들기
    }
    
    public void dfs(String start, String path, int cnt, String[][] tickets) {
        if(cnt == len) {
            list.add(path);  //리스트에 추가
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(!check[i] && tickets[i][0].equals(start)) {  //출발지가 같은지
                check[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], cnt+1, tickets);  //출발지에 도착지 넣고, 경로에 추가하기
                check[i] = false;
            }
        }
        
    }
}


// icn atl, atl icn, icn sfo, sfo atl, atl sfo 
// icn sfo, sfo atl, atl sfo, 