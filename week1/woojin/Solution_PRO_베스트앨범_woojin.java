import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        //map에 "장르", 재생횟수 저장
        //가장 많이 재생한 장르찾기 (조건1)
        //해당 장르인 노래 찾아서 먼저 수록 (조건2)
        
        Map<String, Integer> map = new HashMap<>();
        int size = genres.length;
        
        for(int i=0; i<size; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        //재생횟수 많은순으로 장르 정렬
        List<String> list = new ArrayList<>();
        for(String key : map.keySet()) {
            list.add(key);
        }
        
        Collections.sort(list, (o1, o2) -> map.get(o2) - map.get(o1));
                
        List<Integer> answerList = new ArrayList<>();
        for(int i=0; i<list.size(); i++) {
            List<Integer> priority = new ArrayList<>();
            for(int idx=0; idx<size; idx++) {  //고유번호가 낮은 순으로 먼저 비교 수록 (조건3)
                if(list.get(i).equals(genres[idx])) {
                    priority.add(idx); 
                }
            }
            
            //plays에서 재생횟수 많은 순서대로 정렬
            Collections.sort(priority, (o1, o2) -> plays[o2] - plays[o1]);
            
            for(int j=0; j<priority.size(); j++) {
                if(j>=2) break; 
                answerList.add(priority.get(j));
            }
        }
        
        int[] answer = new int[answerList.size()];  //정답 담은 배열
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
//     static class Music {
//         String genre;
//         int play;
//         int idx;
    
//         public Music(String genre, int play, int idx) {
//             this.genre = genre; 
//             this.play = play;
//             this.idx = idx;
//         }
//     }
}
