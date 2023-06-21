import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        answer = new int[id_list.length];
        
        Map<String, HashSet<String>> reportedMap = new HashMap<>(); // [신고된ID, [신고한ID]]
        Map<String, Integer> answerMap = new HashMap<>(); // [신고된Id, 메일 수]
        
        //기본세팅(유저 리스트를 불러와서 몇번 신고되었는지 count 할 수 있도록 세팅)
        for(int i = 0; i < id_list.length; i++){
            HashSet<String> report_id = new HashSet<>();
            reportedMap.put(id_list[i], report_id);
            answerMap.put(id_list[i], 0);
        }
        
        for(String r : report){
            String[] reportStr = r.split(" ");
            String report_id = reportStr[0];
            String reported_id = reportStr[1];
            reportedMap.get(reported_id).add(report_id);
        }
        
        for(String reported_id : reportedMap.keySet()){
            HashSet<String> userForSend = reportedMap.get(reported_id); // n번째유저를 신고한 유저들
            if(userForSend.size() >= k){
                for(String userId : userForSend){
                    answerMap.put(userId, answerMap.get(userId) + 1);
                }
            }
        }
        
        for (int i = 0; i < id_list.length; i++) {
			answer[i] = answerMap.get(id_list[i]);
		}
        
        return answer;
    }
}