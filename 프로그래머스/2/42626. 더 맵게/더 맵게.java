import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>();

        for (int sco : scoville) {
            queue.add(sco);
        }

        int currentSco = queue.peek();
        while (currentSco < K) {   
            if (queue.size() < 2)
                return -1;
            
                     
            int mixSco = queue.poll() + (queue.poll() * 2);
            queue.add(mixSco);
            
            currentSco = queue.peek();
            answer++;
        }
        return answer;
    }

}
