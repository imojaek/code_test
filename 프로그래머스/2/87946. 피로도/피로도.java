class Solution {
    private int maxCount = 0;
    public int solution(int p, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        
        func(dungeons, visited, p, 0);

        return maxCount;
    }

    public void func(int[][] dungeons, boolean[] visited, int p, int currentClearCount) {
        maxCount = Math.max(maxCount, currentClearCount);

        if (p > 0) {
            for (int i = 0; i < dungeons.length; i++) {
                if (!visited[i] && p >= dungeons[i][0]) {
                    visited[i] = true;
                    func(dungeons, visited, p - dungeons[i][1], currentClearCount + 1);
                    visited[i] = false;
                }
            }
        }
    }
}