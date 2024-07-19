package boj;

import java.util.Scanner;

public class BOJ30802 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        int xl = sc.nextInt();
        int xxl = sc.nextInt();
        int xxxl = sc.nextInt();
        int tBundle = sc.nextInt();
        int penBundle = sc.nextInt();

        int[] result = new int[3]; // 티셔츠 묶음, 펜 묶음, 펜 개별구매 각각의 개수

        result[0] = getAmount(s, tBundle) + getAmount(m, tBundle) + getAmount(l, tBundle)
                + getAmount(xl, tBundle) + getAmount(xxl, tBundle) + getAmount(xxxl, tBundle);
        result[1] = people / penBundle;
        result[2] = (people % penBundle);

        System.out.println(result[0]);
        System.out.print(result[1] + " " + result[2]);
    }
    private static int getAmount(int tSize, int tBundle) {
        return tSize / tBundle + (tSize % tBundle > 0 ? 1 : 0);
    }
}
