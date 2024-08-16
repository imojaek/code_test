import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mixTime = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        long tmp;
        for (int i = 0; i < mixTime; i++) {
            tmp = arr[0] + arr[1];
            arr[0] = tmp;
            arr[1] = tmp;
            Arrays.sort(arr);
        }

        Long result = 0L;
        for (int i = 0; i < n; i++)
            result += arr[i];
        System.out.println(result);
    }
}
