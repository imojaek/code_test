package boj;

import java.util.Scanner;

public class BOJ1052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        boolean[] reverseBinary = new boolean[25]; // 원래는 24자 이진수이지만, 100000000000000000000001 을 물병 하나로 만드려면 자리수를 하나 증가시켜야 한다. 그래서 크기가 25인 배열을 사용한다.
        sc.close();

        int bottle = 0;
        int needBottle = 0;

        for (int i = 0; i < 24; i++) { // 현재 병의 개수 파악하기.
            if (N % 2 == 1) {
                reverseBinary[i] = true;
                bottle++;
            }
            N /= 2;
            if (N == 0) {
                break;
            }
        }

        while (bottle > K) {
            for (int i = 0; i < 24; i++) {
                if (reverseBinary[i]) { // 병을 줄이기 위한 연산
                    needBottle += (int) Math.pow(2, i);
                    reverseBinary[i] = false;
                    bottle--;

                    for (int j = i + 1; j < 24; j++) { // 자리수 계산
                        if (reverseBinary[j]) {
                            reverseBinary[j] = false;
                            bottle--;
                        }
                        else {
                            reverseBinary[j] = true;
                            bottle++;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        System.out.print(needBottle);
    }
}
