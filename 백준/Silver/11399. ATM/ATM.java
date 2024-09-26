import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(input[i]));
        }

        int time = 0;
        int answer = 0;

        while (!pq.isEmpty()) {
            time += pq.poll();
            answer += time;
        }
        System.out.println(answer);
    }
}
