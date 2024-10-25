import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (j1, j2) -> {
            return j1[0] - j2[0];
        });

        int progress = 0;
        Queue<int[]> queue = new PriorityQueue<>((j1, j2) -> {
            return j1[1] - j2[1];
        });

        int timer = 0;
        int index = 0;

        while (progress < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= timer) {
                queue.add(jobs[index++]);
            }

            if (!queue.isEmpty()) {
                int[] currentJob = queue.poll();
                timer += currentJob[1];
                answer += timer - currentJob[0];
                progress++;
            }
            else {
                timer = jobs[index][0];
            }
        }

        return answer / jobs.length;
    }
}
