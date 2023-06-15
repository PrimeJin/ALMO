class Solution {
    public String solution(String input_string) {
        String answer = "";
        int[] alpha = new int[26];
        int count=1;

        for(char spell: input_string.toCharArray()){
            int spellIdx = alpha[(int)(spell-'a')];
            // System.out.println(spell + " " + count + " " + spellIdx);

            if(spellIdx == 0 || (count - spellIdx) == 1) alpha[(int)(spell-'a')] = count;
            else alpha[(int)(spell-'a')] = -1;

            count++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<26; i++){
            if(alpha[i] == -1) stringBuilder.append((char)('a'+i));
        }

        answer = stringBuilder.toString();
        if(answer.equals("")) answer="N";
        return answer;
    }
}