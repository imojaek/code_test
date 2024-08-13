import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] inputArr = new int[n][2];
        for (int i = 0; i < n; i++) {
            inputArr[i][0] = sc.nextInt();
            inputArr[i][1] = sc.nextInt();
        }

        Arrays.sort(inputArr, (t1, t2) -> {
            if (t1[1] == t2[1]) {
                return t1[0] - t2[0];
            }
            return t1[1] - t2[1];
        });
        
        int result = 0;
        int endTime = 0;
        for (int i = 0; i < n; i++) {
            if (inputArr[i][0] >= endTime) {
                endTime = inputArr[i][1];
                result++;
            }
        }
        System.out.println(result);
    }
}
