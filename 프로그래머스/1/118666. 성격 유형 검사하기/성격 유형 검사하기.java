import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String AN = "AN";
        String RT = "RT";
        String CF = "CF";
        String JM = "JM";
        Map<String, Integer> map = new HashMap<>();
        map.put(RT, 0);
        map.put(CF, 0);
        map.put(JM, 0);
        map.put(AN, 0); // 사전순으로 배치
        
        
        
        for (int i = 0; i < survey.length; i++) {
            
            char c = survey[i].charAt(0);
            if (c == 'A') {
                map.put(AN, map.get(AN) + choices[i] - 4);
            }
            else if (c == 'N') {
                map.put(AN, map.get(AN) + 4 - choices[i]);
            }
            else if (c == 'J') {
                map.put(JM, map.get(JM) + choices[i] - 4);
            }
            else if (c == 'M') {
                map.put(JM, map.get(JM) + 4 - choices[i]);
            }
            else if (c == 'C') {
                map.put(CF, map.get(CF) + choices[i] - 4);
            }
            else if (c == 'F') {
                map.put(CF, map.get(CF) + 4 - choices[i]);
            }
            else if (c == 'R') {
                map.put(RT, map.get(RT) + choices[i] - 4);
            }
            else if (c == 'T') {
                map.put(RT, map.get(RT) + 4 - choices[i]);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(map.get(RT) <= 0 ? "R" : "T");
        sb.append(map.get(CF) <= 0 ? "C" : "F");
        sb.append(map.get(JM) <= 0 ? "J" : "M");
        sb.append(map.get(AN) <= 0 ? "A" : "N");
        return sb.toString();
    }
}