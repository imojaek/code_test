class Solution {
    int answer = 0;
    int[] numberGlobal;
    int targetGlobal;
    public int solution(int[] numbers, int target) {
        numberGlobal = numbers;
        targetGlobal = target;

        dfs(0, 0);

        return answer;
    }

    public void dfs(int currentPos, int currentSum) {
        if (currentPos == numberGlobal.length) {
            if (currentSum == targetGlobal) {
                answer++;
            }
            return ;
        }

        dfs(currentPos + 1, currentSum + numberGlobal[currentPos]);
        dfs(currentPos + 1, currentSum - numberGlobal[currentPos]);
        return ;
    }
}