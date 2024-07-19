package boj;

import java.util.Scanner;

public class BOJ1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            if (str.equals("0")) {
                break;
            }
            int i = 0;
            boolean flag = false;
            while (i < str.length() / 2) {
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    flag = true;
                    break;
                }
                i++;
            }
            String result = flag ? "no" : "yes";
            System.out.println(result);
        }
    }
}
