import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][3];
        String[] split =  br.readLine().split(" ");
        for (int i = 0; i < 3; i++) {
            cost[0][i] = Integer.parseInt(split[i]);
        }

        for (int i = 1; i < N; i++) {
            split = br.readLine().split(" ");
            cost[i][0] = Math.min(cost[i - 1][1], cost[i - 1][2]) + Integer.parseInt(split[0]);
            cost[i][1] = Math.min(cost[i - 1][0], cost[i - 1][2]) + Integer.parseInt(split[1]);
            cost[i][2] = Math.min(cost[i - 1][0], cost[i - 1][1]) + Integer.parseInt(split[2]);
        }

        int result = Math.min(cost[N - 1][0], Math.min(cost[N - 1][1], cost[N - 1][2]));
        System.out.println(result);
    }
}
