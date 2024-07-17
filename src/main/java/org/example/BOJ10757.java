package org.example;

import java.util.Scanner;

public class BOJ10757 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        char[] reverseResult = new char[10001]; // 최대 10000자리의 숫자(10^10000 미만), 올림수까지 10001개

        int lengthA = a.length();
        int lengthB = b.length();

        int indexA = lengthA - 1; // 각 문자열의 일의 자리부터 가져오기 위한 인덱스
        int indexB = lengthB - 1;

        int tmp = 0; // 한자리씩 계산하는 데에 사용

        for (int i = 0; i < Math.max(lengthA, lengthB); i++) {
            if (indexA >= 0) {
                tmp += a.charAt(indexA--) - '0';
            }
            if (indexB >= 0) {
                tmp += b.charAt(indexB--) - '0';
            }
            reverseResult[i] = (char) (tmp % 10 + '0'); // 일의 자리부터 거꾸로 넣기.

            tmp /= 10; // 이번 자리의 계산 결과가 10 이상인 경우 올림수 1을 의미.
        }

        int flag = 0;
        if (tmp == 1) {
            reverseResult[Math.max(lengthA, lengthB)] = '1';
            flag = 1;
        }

        for (int i = Math.max(lengthA, lengthB) - 1 + flag; i >= 0; i--) {
            System.out.print(reverseResult[i]);
        }
    }
}
