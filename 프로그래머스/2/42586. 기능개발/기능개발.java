import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int time = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                time++;
            }
            queue.add(time);
        }
        
        List<Integer> list = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int currentTime = queue.poll();
            int count = 1;
            while (!queue.isEmpty() && queue.peek() <= currentTime) {
                queue.poll();
                count++;
            }
            list.add(count);
        }

        answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}