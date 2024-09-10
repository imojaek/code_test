class Solution {
    public int[] solution(int[] num_list, int n) {
        int size = num_list.length;
        int arrSize = size % n > 0 ? size / n + 1 : size / n;
        int[] answer = new int[arrSize];
        for(int i = 0; i < arrSize; i++) {
            answer[i] = num_list[0 + n * i]; 
        }
        return answer;
    }
}