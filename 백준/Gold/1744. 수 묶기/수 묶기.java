import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        int n1 = 0;
        int n2 = 0;
        boolean flag = false;

        if (pq.size() == 1) {
            System.out.println(pq.poll());
        }
        else {
            while (pq.size() > 1) {
                if (pq.peek() <= 0) {
                    flag = true;
                    break;
                }
                n1 = pq.poll();
                n2 = pq.peek();
                if (n1 * n2 > n1 + n2) {
                    answer += n1 * n2;
                    pq.poll();
                }
                else {
                    answer += n1;
                }
            }
            if (flag) {
                if (pq.size() % 2 == 0) {
                    while (!pq.isEmpty()) {
                        answer += pq.poll() * pq.poll();
                    }
                }
                else {
                    answer += pq.poll();
                    while (!pq.isEmpty()) {
                        answer += pq.poll() * pq.poll();
                    }
                }
            }
            if (pq.size() == 1)
                answer += pq.poll();
            System.out.println(answer);
        }

    }
}
