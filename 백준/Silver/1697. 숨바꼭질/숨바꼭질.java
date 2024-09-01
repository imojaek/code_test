import java.util.*;
public class Main {
    static int start;
    static int target;

    static Queue<int[]> queue = new LinkedList<>();
    static int isVisited[] = new int[100001];
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        start = sc.nextInt();
        target = sc.nextInt();

        queue.add(new int[]{start, 0});
        isVisited[start] = 1;
        result = bfs();
        System.out.println(result);
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            int[] currentPos = queue.poll();
            int pos = currentPos[0];
            int depth = currentPos[1];

            if (pos == target) {
                return depth;
            }

            int[] nextPos = new int[]{pos - 1, pos + 1, pos * 2};
            for (int i = 0; i < nextPos.length; i++) {
                int next = nextPos[i];
                if (next >= 0 && next <= 100000 && isVisited[next] == 0) {
                    if (next == target) {
                        return depth + 1;
                    }
                    isVisited[next] = 1;
                    queue.add(new int[]{next, depth + 1});
                }
            }
        }
        return -1;
    }
}
