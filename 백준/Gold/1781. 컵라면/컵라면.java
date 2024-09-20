import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Problem> pq = new PriorityQueue<>((a, b) -> {
            if (a.deadline == b.deadline) {
                return b.cup - a.cup;
            }
            return a.deadline - b.deadline;
        });
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int deadline = Integer.parseInt(input[0]);
            int cup = Integer.parseInt(input[1]);

            pq.add(new Problem(deadline, cup));
        }

        int answer = 0;

        PriorityQueue<Integer> cupQueue = new PriorityQueue<>();

        while (!pq.isEmpty()) {
            Problem problem = pq.poll();
            if (problem.deadline > cupQueue.size())
                cupQueue.add(problem.cup);
            else if (cupQueue.peek() < problem.cup) {
                cupQueue.poll();
                cupQueue.add(problem.cup);
            }
        }

        while (!cupQueue.isEmpty()) {
            answer += cupQueue.poll();
        }

        System.out.println(answer);

    }

    public static class Problem {
        int deadline;
        int cup;

        public Problem(int deadline, int cup) {
            this.deadline = deadline;
            this.cup = cup;
        }
    }
}