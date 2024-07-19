package boj;

import java.util.Scanner;

public class BOJ1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int target = sc.nextInt();
            if (target == 2 || target == 3) {
                result++;
                continue;
            }
            int sqrt = (int) Math.sqrt(target);
            for (int j = 2; j <= sqrt; j++) {
                if (target % j == 0) {
                    break;
                }
                if (j == sqrt) {
                    result++;
                }
            }
        }
        System.out.print(result);
    }
}
