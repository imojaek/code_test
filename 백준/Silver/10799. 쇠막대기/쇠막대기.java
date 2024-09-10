import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int result = 0;
        int depth = 0;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '(') {
                if (line.charAt(i + 1) == ')') {
                    result += depth;
                    i++;
                }
                else {
                    depth++;
                }
            }
            else if (c == ')') {
                depth--;
                result++;
            }
        }
        System.out.println(result);
    }
}
