package boj;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            queue.add(sc.nextInt());
        }

        int max = queue.peek();
        

    }
}
