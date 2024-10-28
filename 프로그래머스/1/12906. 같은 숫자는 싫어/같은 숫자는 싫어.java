import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};

        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            if (stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }

        answer = stack.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}