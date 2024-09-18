import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb  = new StringBuilder();
        sb.append(input);
        int cursor = input.length();
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("L"))
                cursor = cursor > 0 ? cursor - 1 : cursor;
            else if (command[0].equals("D"))
                cursor = cursor < sb.length() ? cursor + 1 : cursor;
            else if (command[0].equals("B")) {
                if (cursor > 0) {
                    sb.deleteCharAt(cursor - 1);
                    cursor--;
                }
            }
            else if (command[0].equals("P")) {
                sb.insert(cursor, command[1]);
                cursor++;
            }
        }

        System.out.println(sb);
    }
}
