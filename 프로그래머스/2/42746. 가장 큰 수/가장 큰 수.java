import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        String[] strArr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);

        Arrays.sort(strArr, (str1, str2) -> {
            int len1 = str1.length();
            int len2 = str2.length();
            int max = Math.max(len1, len2);

            for (int i = 0; i < max; i++) {
                char char1 = str1.charAt(i % len1);
                char char2 = str2.charAt(i % len2);

                if (char1 != char2) {
                    return char2 - char1; // 비교했을 떄 다르면 역순으로.
                }
            }

            char last1 = str1.charAt(len1 - 1);
            char last2 = str2.charAt(len2 - 1);
            return last2 - last1;
        });

        if (strArr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }

        return sb.toString();
    }
}