import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[21];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int num = 0;
            switch (input[0]) {
                case "add":
                    num = Integer.parseInt(input[1]);
                    arr[num] = 1;
                    break;
                case "remove":
                    num = Integer.parseInt(input[1]);
                    arr[num] = 0;
                    break;
                case "check":
                    num = Integer.parseInt(input[1]);
                    sb.append(arr[num]).append("\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(input[1]);
                    arr[num] = arr[num] == 1 ? 0 : 1;
                    break;
                case "all":
                    for (int j = 1; j < 21; j++) {
                        arr[j] = 1;
                    }
                    break;
                case "empty":
                    for (int j = 1; j < 21; j++) {
                        arr[j] = 0;
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
}
