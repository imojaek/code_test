import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        Count count = new Count();
        func(arr, 0, 0, N, count);
        System.out.println(count.white);
        System.out.println(count.blue);

    }
    public static void func(int[][] arr, int x, int y, int N, Count count) {
        int sum = 0;
        for (int i = y; i < y + N; i++) {
            for (int j = x; j < x + N; j++) {
                sum += arr[i][j];
            }
        }
        if (sum == N * N) {
            count.blue++;
            return ;
        }
        else if (sum == 0) {
            count.white++;
            return ;
        }

        func(arr, x, y, N / 2, count);
        func(arr, x + N / 2, y, N / 2, count);
        func(arr, x, y + N / 2, N / 2, count);
        func(arr, x + N / 2, y + N / 2, N / 2, count);
    }

    public static class Count {
        int white = 0;
        int blue = 0;
    }
}
