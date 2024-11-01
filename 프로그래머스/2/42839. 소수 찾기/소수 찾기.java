import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;

        Set<Integer> resultSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder targetString = new StringBuilder(numbers);

        func(sb, targetString, resultSet);

        System.out.println(resultSet);

        for (int num : resultSet) {
            if (isPrime(num))
                answer++;
        }

        return answer;
    }

        public void func(StringBuilder sb, StringBuilder targetString, Set<Integer> resultSet) {
        if (sb.length() > 0) {
            int num = Integer.parseInt(sb.toString());
            resultSet.add(num);
        }
        for (int i = 0; i < targetString.length(); i++) {
            char c = targetString.charAt(i);
            sb.append(c);
            targetString.deleteCharAt(i);

            func(sb, targetString, resultSet);

            // 복구?
            targetString.insert(i, c);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}