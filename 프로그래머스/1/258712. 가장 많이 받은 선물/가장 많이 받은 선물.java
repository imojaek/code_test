import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> friendsMap = new HashMap<>();
        for(String name : friends) {
            friendsMap.put(name, friendsMap.size()); // 이름, 인덱스
        }
        
        int[][] giftScore = new int[friends.length][friends.length];
        
        for (String gift : gifts) {
            String[] sp = gift.split(" ");
            int sender = friendsMap.get(sp[0]);
            int taker = friendsMap.get(sp[1]);
            
            giftScore[sender][taker]++;
        }
        
        int[] tjsanfwltn = new int[friends.length];
        for(int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                tjsanfwltn[i] += giftScore[i][j];
                tjsanfwltn[i] -= giftScore[j][i];
            }
        }
        
        int[] willTakeGift = new int[friends.length];
        
        for(int i = 0; i < friends.length; i++) {
            for(int j = i + 1; j < friends.length; j++) {
                if (giftScore[i][j] > giftScore[j][i])
                    willTakeGift[i]++;
                else if (giftScore[i][j] < giftScore[j][i])
                    willTakeGift[j]++;
                else {
                    if (tjsanfwltn[i] > tjsanfwltn[j])
                        willTakeGift[i]++;
                    else if (tjsanfwltn[i] < tjsanfwltn[j])
                        willTakeGift[j]++;
                }
            }
        }
        
        for (int willTake : willTakeGift) {
            if (answer < willTake)
                answer = willTake;
        }
        
        
        return answer;
    }
}