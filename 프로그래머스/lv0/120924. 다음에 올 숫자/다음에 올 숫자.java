class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        int indexA = common[1]-common[0];
        int indexB = common[2]-common[1];
        
        int length = common.length;
        
        if(indexA == indexB){                       
            answer = common[length-1] + indexA;
        }
        else{
            int mult = indexB/indexA;
            answer = common[length-1] * mult;
        }
        
        return answer;
    }
}