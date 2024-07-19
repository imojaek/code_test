package boj;

import java.util.Scanner;

public class BOJ2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        int start = Math.max(n - 54, 1); // 숫자의 자리수를 계산해서 9 * 자리수를 빼면 좋을텐데 굳이.?
        for (int i = start; i < n; i++) {
            int sum = i;
            int tmp = i;

            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }

            if (sum == n) {
                result = i;
                break;
            }
        }
        System.out.print(result);
    }
}
