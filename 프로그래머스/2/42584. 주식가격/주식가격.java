import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int targetIdx = stack.pop();
                answer[targetIdx] = i - targetIdx;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int targetIdx = stack.pop();
            answer[targetIdx] = prices.length - 1 - targetIdx;
        }

        return answer;
    }
}