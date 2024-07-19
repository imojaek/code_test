package boj;

import java.util.Scanner;

// 각 숫자 크기가 30000까지라 제곱해야 9억이고 2개 더해도 18억이라 그냥 int
public class BOJ4153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a == 0 && b == 0 && c == 0 ) {
                break;
            }

            int max = Math.max(a, Math.max(b, c));
            int min = Math.min(a, Math.min(b, c));
            int mid = a + b + c - max - min;

            if (max * max == min * min + mid * mid) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
