import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[][] dp = new int[N][2]; // 0 : 몇개인지, 1 : 수열에서 다음 값의 인덱스는 어디인지.
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp[i][0] = 1;
        }

        int max = 1;
        int maxi = 0;

        for (int i = N - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0 ; j--) {
                if (arr[i] > arr[j]) {
                    if (dp[j][0] < dp[i][0] + 1) {
                        dp[j][0] = dp[i][0] + 1;
                        dp[j][1] = i;

                        if (max < dp[j][0]) {
                            max = dp[j][0];
                            maxi = j;
                        }
                    }
                }
            }
        }

        System.out.println(max);
        for (int i = 0; i < max; i++) {
            System.out.print(arr[maxi] + " ");
            maxi = dp[maxi][1];
        }
    }
}
