import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] inputArr = new int[2 * n][2];
        for (int i = 0; i < n; i++) {
            inputArr[2 * i][0] = sc.nextInt();
            inputArr[2 * i][1] = 1;
            inputArr[2 * i + 1][0] = sc.nextInt();
            inputArr[2 * i + 1][1] = -1;
        }

        Arrays.sort(inputArr, (t1, t2) -> {
            return t1[0] - t2[0];
        });

        int result = 0;
        int needRoom = 0;
        int currentTime = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (currentTime != inputArr[i][0]){
                result = Math.max(result, needRoom);

                currentTime = inputArr[i][0];
            }
            needRoom += inputArr[i][1];
        }
        result = Math.max(result, needRoom);

        System.out.println(result);
    }
}
