import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] score = new int[N + 1];
        if (N == 1) {
            System.out.println(arr[1]);
        }
        else if (N == 2) {
            System.out.println(arr[1] + arr[2]);
        }
        else {
            score[1] = arr[1];
            score[2] = arr[1] + arr[2];
            for (int i = 3; i < N + 1; i++) {
                score[i] = arr[i] + Math.max(score[i - 2], score[i - 3] + arr[i - 1]);
            }
            System.out.println(score[N]);
        }
    }
}
