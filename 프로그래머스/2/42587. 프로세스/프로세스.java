import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
            map.put(priorities[i], map.getOrDefault(priorities[i], 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
        }
        
        int count = 0;
        int[] maxPriority = pq.poll();
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[1] == maxPriority[0]) {
                count++;
                if (current[0] == location) {
                    answer = count;
                    break;
                }
                maxPriority[1]--;
                if (maxPriority[1] == 0 && !pq.isEmpty()) {
                    maxPriority = pq.poll();
                }
            }
            else {
                queue.add(current);
            }
        }


        return answer;
    }
}