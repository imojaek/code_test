import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] lineArr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lineArr[i][0] = Integer.parseInt(st.nextToken());
            lineArr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lineArr, (l1, l2) -> {
            if (l1[0] == l2[0]) {
                return l1[1] - l2[1];
            }
            return l1[0] - l2[0];
        });

        int result = 0;
        int start = lineArr[0][0];
        int end = lineArr[0][1];

        for (int i = 1; i < n; i++) {
            if (lineArr[i][0] < end) {
                end = Math.max(end, lineArr[i][1]);
            } else {
                result += end - start;

                start = lineArr[i][0];
                end = lineArr[i][1];
            }
        }

        result += end - start;

        System.out.println(result);
    }
}
