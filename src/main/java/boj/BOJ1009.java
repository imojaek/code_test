package boj;


import java.util.Scanner;

/*
1의 자리 만 계산해서 같은 게 나오면 그 리스트 그대로 반환
 */
public class BOJ1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] arr = new int[T][2];

        int[] resultArr = new int[4];

        for (int i = 0; i < T; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for (int i = 0; i < T; i++) {
            int a = arr[i][0] % 10;
            if (a == 0) { // 일의 자리가 0인 경우, 0이 출력해서 문제가 되었다.
                System.out.println(10);
                continue;
            }
            int b = arr[i][1];
            int result = 1;
            int loop = 0;

            for (int j = 0; j < b; j++) {
                result = (result * a) % 10;
                if (j > 0 && result == a) {
                    loop = j; // 하나의 루프가 몇개인지 확인한다.
                    break;
                }
                else {
                    resultArr[j] = result;
                }
            }

            if (loop == 0) { // 일의자리 루프가 완성되지 않은 채 반복문을 탈출한 경우 현재 일의자리를 그대로 출력
                System.out.println(result);
                continue;
            }
            System.out.println(resultArr[(b - 1) % loop]);
        }
    }
}
