package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ10757v2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        List<String> strList = new ArrayList<>();

        int remainLengthA = a.length();
        int remainLengthB = b.length();

        int numA = 0;
        int numB = 0;
        int tmp = 0; // 계산하는 데에 사용
        int carry = 0;

        while(remainLengthA > 0 || remainLengthB > 0) {
            if (remainLengthA > 9) {
                numA = Integer.parseInt(a.substring(remainLengthA - 9, remainLengthA)); // 딱 9자리를 문자열로 바꾸고 그걸 Int로 변환
            }
            else if (remainLengthA > 0) {
                numA = Integer.parseInt(a.substring(0, remainLengthA)); // 9자리 이하로 남은 경우 처리
            }

            if (remainLengthB > 9) {
                numB = Integer.parseInt(b.substring(remainLengthB - 9, remainLengthB));
            }
            else if (remainLengthB > 0) {
                numB = Integer.parseInt(b.substring(0, remainLengthB));
            }

            tmp = numA + numB + carry;
            carry = 0;

            if (tmp >= 1000000000) { // 9자리 숫자의 덧셈의 결과가 10억이 넘어가는 경우 1을 올림수로 처리할 수 있도록.
                carry = 1;
                tmp -= 1000000000;
            }


            remainLengthA -= 9;
            remainLengthB -= 9;

            if (remainLengthA > 0 || remainLengthB > 0)
                strList.add(String.format("%09d", tmp)); // 중간 숫자들은 앞에 0을 붙여 모두 9자리를 유지할 수 있도록.
            else
                strList.add(String.valueOf(tmp)); // 가장 높은 자리 숫자는 숫자 앞에 0을 붙여 9자리를 유지하지 않아도 되기 때문에 처리.
            numA = 0;
            numB = 0;
        }

        if (carry == 1) { // 올림수만 남은경우 처리 ex) 123456789 + 999999999
            strList.add("1");
        }

        for (int i = strList.size() - 1; i >= 0 ; i--) {
            System.out.print(strList.get(i));
        }
    }
}
