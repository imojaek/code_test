import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Map<String, Integer>> reported = new HashMap<>();        
        for (String id : id_list) {
            map.put(id, new ArrayList<String>());
            reported.put(id, new HashMap<>());
        }
        
        for (String rep : report) {
            String[] sp = rep.split(" ");
            map.get(sp[0]).add(sp[1]);
            reported.get(sp[1]).put(sp[0], 0);
        }
        
        
        List<String> target = new ArrayList<>();
        for (int i = 0; i < id_list.length; i++) {
            if (reported.get(id_list[i]).size() >= k) {
                target.add(id_list[i]);
            }
        }
        
        for (String banned : target) {
            for (int i = 0; i < id_list.length; i++) {
                if (reported.get(banned).containsKey(id_list[i])) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}