import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);
        int y = Integer.parseInt(input[2]);

        int result;

        result = func((int) Math.pow(2, N), x, y);
        System.out.println(result);
    }
    public static int func(int N, int x, int y) {
        if (N == 0)
            return 0;
        if (N == 1)
            return 2 * x + y;

        int mid = N / 2;
        int size = mid * mid;

        if (x < mid && y < mid) {
            return func(mid, x, y);
        }
        else if (x < mid && y >= mid) {
            return size + func(mid, x, y % mid);
        }
        else if (x >= mid && y < mid) {
            return 2 * size + func(mid, x % mid, y);
        }
        else {
            return 3 * size + func(mid, x % mid, y % mid);
        }
    }
}
