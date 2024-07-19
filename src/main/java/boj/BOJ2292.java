package boj;

import java.util.Scanner;

public class BOJ2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int step = 1;
        int maxRoomOfStairs = 1;

        while (n > maxRoomOfStairs) {
            maxRoomOfStairs += 6 * step;
            step++;
        }

        System.out.print(step);
    }
}
