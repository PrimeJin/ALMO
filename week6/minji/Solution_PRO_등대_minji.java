import java.util.*;

class Solution {
    public class Light{
        int number;
        LinkedList<Integer> list;

        public Light(int number){
            this.number = number;
            this.list = new LinkedList<Integer>();
        }

        public void addLinked(int number){
            this.list.add(number);
        }
    }

    public static int answer = Integer.MAX_VALUE;

    public int solution(int n, int[][] lighthouse) {

        Light[] lightList = new Light[n+1];
        lightList[0] = new Light(0);

        boolean[] isBright = new boolean[n-1];

        for(int i=0; i<lighthouse.length;i++ ){
            int number1 = lighthouse[i][0];
            int number2 = lighthouse[i][1];

            if(lightList[number1] == null){
                lightList[number1] = new Light(number1);
            }
            lightList[number1].addLinked(i);

            if(lightList[number2] == null){
                lightList[number2] = new Light(number2);
            }
            lightList[number2].addLinked(i);
        }
        dfs(isBright, n, lighthouse, lightList,0,0);

        return answer;
    }

    public void dfs(boolean[] isBright, int n, int[][] lighthouse, Light[] lightList, int count, int isDoneCount){

        if(isDoneCount >= n-1){
            answer = Math.min(answer,count);
            return;
        }

        for(int i=0; i< n-1; i++){
            if(isBright[i]) continue;

            boolean[] isBrightCopy = isBright.clone();
            int doneCount = isDoneCount;

            for(int index : lightList[lighthouse[i][0]].list){
                doneCount++;
                isBrightCopy[index] = true;
            }
            dfs(isBrightCopy, n, lighthouse, lightList, count+1,doneCount);

            doneCount = isDoneCount;
            isBrightCopy = isBright.clone();

            for(int index : lightList[lighthouse[i][1]].list){
                doneCount++;
                isBrightCopy[index] = true;
            }
            dfs(isBrightCopy, n, lighthouse, lightList, count+1,doneCount);
        }

    }
}