import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        List<Integer> nums = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                nums.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
                operators.add(c);
            }
        }
        nums.add(Integer.parseInt(sb.toString()));


        int result = nums.get(0); // 첫번째 숫자는 그대로 result에 넣고 2번째 숫자부터 연산기호에 영향을 받는다.
        boolean hasMinus = false;
        for (int i = 0; i < operators.size() ; i++) {
            if (!hasMinus && operators.get(i) == '-') {
                hasMinus = true;
            }

            if (hasMinus) {
                result -= nums.get(i + 1);
            } else {
                result += nums.get(i + 1);
            }
        }
        System.out.println(result);
    }
}
