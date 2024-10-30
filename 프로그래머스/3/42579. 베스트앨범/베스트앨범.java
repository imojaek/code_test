import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String, PriorityQueue<int[]>> songMap = new HashMap<>();
        Map<String, Integer> genreMap = new HashMap<>();

        int len = genres.length;
        for (int i = 0; i < len; i++) {
            // 장르별 노래들의 재생순 정렬
            if (!songMap.containsKey(genres[i])) {
                songMap.put(genres[i], new PriorityQueue<>((a, b) -> {
                    if (a[0] != b[0])
                        return b[0] - a[0];
                    else
                        return a[1] - b[1];
                }));
            }
            songMap.get(genres[i]).add(new int[]{plays[i], i});

            // 장르별 재생 횟수 기록
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        PriorityQueue<String> genreQueue = new PriorityQueue<>((a, b) -> genreMap.get(b) - genreMap.get(a));
        genreQueue.addAll(genreMap.keySet());

        List<Integer> answerList = new ArrayList<>();
        while (!genreQueue.isEmpty()) {
            PriorityQueue<int[]> current = songMap.get(genreQueue.poll());
            for (int i = 0; i < 2; i++) {
                if (current.isEmpty())
                    continue;
                answerList.add(current.poll()[1]);
            }
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }
}