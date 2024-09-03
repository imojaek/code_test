import java.util.*;

public class Main {
    static int n, m;

    static int[] color;
    static List<List<Integer>> graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int t = 0; t < testCase; t++) {
            n = sc.nextInt();
            m = sc.nextInt();

            color = new int[n + 1];
            graph = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int p1 = sc.nextInt();
                int p2 = sc.nextInt();
                graph.get(p1).add(p2);
                graph.get(p2).add(p1);
            }

            boolean result = true;
            for (int i = 1; i < n + 1; i++) {
                if (color[i] == 0) {
                    if (bfs(i) == false) {
                        result = false;
                        break;
                    }
                }
            }
            if (result) {
                System.out.println("possible");
            } else {
                System.out.println("impossible");
            }
        }
    }

    public static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1; // 시작 색깔은 1, 다음 색깔은 2
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Integer next : graph.get(current)) {
                if (color[next] == 0) {
                    if (color[current] == 1) {
                        color[next] = 2;
                    } else {
                        color[next] = 1;
                    }
                    queue.add(next);
                }
                else if (color[next] == color[current]) {
                    return false;
                }
            }
        }
        return true;
    }
}
