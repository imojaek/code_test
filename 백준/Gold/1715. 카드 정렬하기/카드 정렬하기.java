import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(br.readLine()));
        }

        Long answer = 0L;

        while (pq.size() > 1) {
            Long n1 = pq.poll();
            Long n2 = pq.poll();
            if (n1 == null || n2 == null)
                break;

            answer += n1 + n2;
            pq.offer(n1 + n2);
        }
        System.out.println(answer);
    }
}