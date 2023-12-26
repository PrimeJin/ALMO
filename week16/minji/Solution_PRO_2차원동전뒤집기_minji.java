import java.util.*;

class Solution {
    public static int xSize,ySize,totalSize;
    public static int[][] origin, finalMap;
    public int solution(int[][] beginning, int[][] target) {
        int answer = 0;
        xSize = beginning.length;
        ySize = beginning[0].length;
        totalSize = xSize + ySize;
        origin = beginning;
        finalMap = target;

        if(compare()) return 0;

        answer = -1;

        for(int i=1; i<totalSize; i++){
            //바꿀 행, 열 선택
            if(combi(i,0,0)){
                answer=i;
                break;
            }
        }

        return answer;
    }

    public static boolean combi(int selectTotal, int count, int start){
        if(count == selectTotal){
            boolean result = false;

            if(compare()) result=true;

            return result;
        }

        for(int i=start;i<totalSize;i++){
            if(i < xSize){
                changeX(i);
                if(combi(selectTotal,count+1,i)) return true;
                changeX(i);
            }else{
                changeY(i - xSize);
                if(combi(selectTotal,count+1,i)) return true;
                changeY(i - xSize);
            }
        }

        return false;
    }

    public static void changeX(int numX){
        for(int i=0; i<ySize; i++){
            if(origin[numX][i] == 1) origin[numX][i] = 0;
            else origin[numX][i] = 1;
        }
    }
    public static void changeY(int numY){
        for(int i=0; i<xSize; i++){
            if(origin[i][numY] == 1) origin[i][numY] = 0;
            else origin[i][numY] = 1;
        }
    }

    public static boolean compare(){
        for(int i=0; i<xSize; i++){
            for(int j=0; j<ySize; j++){
                if(origin[i][j] != finalMap[i][j]) return false;
            }
        }
        return true;
    }
}