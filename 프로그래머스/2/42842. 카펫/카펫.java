class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = {};
            int range = brown / 2 + 2;
            for (int y = 3; y <= range / 2; y++) {
                int x = range - y;
                int inside = (y - 2) * (x - 2);
                if (inside == yellow) {
                    answer = new int[]{x, y};
                }

            }
            return answer;
        }
    }