import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 각 사용자의 신고당한 횟수를 저장할 Map
        Map<String, Integer> reportCountMap = new HashMap<>();
        // 신고된 사람 목록을 저장할 Set
        Set<String> reportedSet = new HashSet<>();
        // 각 사용자가 신고한 횟수를 저장할 Map
        Map<String, Set<String>> reportListMap = new HashMap<>();
        
        // 각 사용자별로 신고 횟수 및 신고 목록 계산
        for(String rp : report) {
            String[] split = rp.split(" ");
            String reporter = split[0];
            String reportedUser = split[1];
            
            // 중복 신고 방지를 위해 reported Set을 사용
            if(!reportedSet.contains(rp)) {
                reportedSet.add(rp);
                reportCountMap.put(reportedUser, reportCountMap.getOrDefault(reportedUser, 0) + 1);
                
                // 해당 사용자가 신고한 목록을 저장하는 Set을 가져와서 신고자 추가
                if (!reportListMap.containsKey(reportedUser)) {
                    reportListMap.put(reportedUser, new HashSet<>());
                }
                reportListMap.get(reportedUser).add(reporter);
            }
        }
        
        // 각 사용자별로 ban 당한 경우 신고자에게 메일을 보내는지 여부 계산
        for(int i = 0; i < id_list.length; i++) {
            String reportedUser = id_list[i];
            
            // 해당 사용자가 신고당한 횟수가 k 이상인 경우 처리
            if(reportCountMap.containsKey(reportedUser) && reportCountMap.get(reportedUser) >= k) {
                Set<String> reporters = reportListMap.get(reportedUser);
                for(String reporter : reporters) {
                    int idx = Arrays.asList(id_list).indexOf(reporter);
                    if(idx != -1) {
                        answer[idx]++;
                    }
                }
            }
        }
        
        return answer;
    }
}