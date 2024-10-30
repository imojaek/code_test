import java.util.PriorityQueue;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((cit1, cit2) -> cit2 - cit1);
        for (int citation : citations) {
            pq.add(citation);
        }

        int len = citations.length;

        for (int i = 1; i < len + 1; i++) {
            int current = pq.poll();
            if (current < i) {
                return i - 1;
            }
        }

        return len;
    }
}