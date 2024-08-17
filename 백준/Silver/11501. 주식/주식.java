import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());
        for (int i = 0; i < times; i++) {
            int days = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            System.out.println(sol(days, st));
        }
    }

    public static Long sol(int days, StringTokenizer st) {
        Long result = 0L;
        int[] priceArr = new int[days];
        int[] targetPriceArr = new int[days];
        for (int i = 0; i < days; i++) {
            priceArr[i] = Integer.parseInt(st.nextToken());
        }

        int currentTargetPrice = priceArr[days - 1];
        for (int i = days - 1; i >= 0; i--) {
            if (priceArr[i] > currentTargetPrice) {
                currentTargetPrice = priceArr[i];
            }
            targetPriceArr[i] = currentTargetPrice;
        }


        for (int i = 0; i < days; i++) {
            result += targetPriceArr[i] - priceArr[i];
        }
        return result;
    }
}
