import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> resultList = new ArrayList<>();
        String[] todayArr = today.split("\\.");
        int todayY = Integer.parseInt(todayArr[0]);
        int todayM = Integer.parseInt(todayArr[1]);
        int todayD = Integer.parseInt(todayArr[2]);
        
        Map<String, Integer> termsMap = new HashMap<>();
        for(int i = 0; i < terms.length; i++) {
            String[] tmp = terms[i].split(" ");
            termsMap.put(tmp[0], Integer.parseInt(tmp[1]));
        }
        

        for(int i = 0; i < privacies.length; i++) {
            String[] tmp2 = privacies[i].split(" ");
            
            String targetDay = tmp2[0];
            String[] dayArr = targetDay.split("\\.");
            int targetY = Integer.parseInt(dayArr[0]);
            int targetM = Integer.parseInt(dayArr[1]);
            int targetD = Integer.parseInt(dayArr[2]);
            
            String targetTerm = tmp2[1];
            int availableMonth = termsMap.get(targetTerm);
            
            if (targetY * 12 + targetM + availableMonth 
                    < todayY * 12 + todayM) {
                resultList.add(i + 1);
            }
            else if (targetY * 12 + targetM + availableMonth == todayY * 12 + todayM
                        && todayD >= targetD) {
                resultList.add(i + 1);
            }
        }
        
        answer = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        return answer;
    }
}
