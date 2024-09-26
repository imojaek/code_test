import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        Fib[] arr = new Fib[41];
        arr[0] = new Fib(1, 0);
        arr[1] = new Fib(0, 1);

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = 2; j < n + 1; j++) {
                arr[j] = new Fib(arr[j - 1].zero + arr[j - 2].zero, arr[j - 1].one + arr[j - 2].one);
            }
            System.out.println(arr[n].zero + " " + arr[n].one);
        }
    }

    public static class Fib {
        public int zero;
        public int one;

        public Fib(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
    }
}