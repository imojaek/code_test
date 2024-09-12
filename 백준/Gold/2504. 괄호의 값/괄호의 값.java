import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] num = new int[16];
        Stack<Integer> stack = new Stack<>();
        
        /*
        괄호가 열릴떄마다 depth를 증가시키고, 해당 깊이에서의 계산 결과를 num[depth]에 저장토록 한다.
        괄호가 닫히는 경우엔 depth + 1의 결과를 가져와서 괄호에 따라 곱하게 한다.
         */

        int depth = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // 여는 괄호를 만나면 그냥 푸시
            if (c == '(') {
                stack.push(-1);
                depth++;
            }
            else if (c == '[') {
                stack.push(-2);
                depth++;
            }
            // 닫는 괄호를 만난 경우
            else {
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return ;
                }
                if (c == ')' && stack.peek() == -1) {
                    stack.pop();
                    if (input.charAt(i - 1) == '(')
                        num[depth] += 2;
                    else {
                        num[depth] += 2 * num[depth + 1];
                        num[depth + 1] = 0;
                    }
                } else if (c == ']' && stack.peek() == -2) {
                    stack.pop();
                    if (input.charAt(i - 1) == '[')
                        num[depth] += 3;
                    else {
                        num[depth] += 3 * num[depth + 1];
                        num[depth + 1] = 0;
                    }
                } else {
                    System.out.println(0);
                    return ;
                }
                depth--;
            }
        }
        System.out.println(num[1]);
    }
}
