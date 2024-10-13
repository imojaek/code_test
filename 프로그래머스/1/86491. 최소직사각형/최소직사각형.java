class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxX = 0;
        int maxY = 0;
        
        for (int[] size : sizes) {
            if (size[0] < size[1]) {
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }
            maxX = Math.max(maxX, size[0]);
            maxY = Math.max(maxY, size[1]);
        }
        
        return maxX * maxY;
    }
}