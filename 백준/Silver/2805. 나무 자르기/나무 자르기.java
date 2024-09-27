import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);

        int[] trees = new int[N];
        int start = 0;
        int end = 0;
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(input[i]);
            if (trees[i] > end)
                end = trees[i];
        }

        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (trees[i] > mid)
                    sum += trees[i] - mid;
            }
            if (sum >= target) {
                result = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}