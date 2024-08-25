import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            graph.get(p1).add(p2);
            graph.get(p2).add(p1);
        }

        boolean[] isVisited = new boolean[n + 1];

        Tmp tmp = new Tmp();
        dfs(1, graph, isVisited, tmp, 0);

        System.out.println(tmp.result - 1);
    }

    public static class Tmp {
        public int result = 0;
    }

    public static void dfs(int node, List<List<Integer>> graph, boolean[] isVisited, Tmp tmp, int depth) {
        if (!isVisited[node])
            tmp.result += 1;
        isVisited[node] = true;

        if (depth < 2) {
            for (int currentPoint : graph.get(node)) {
                dfs(currentPoint, graph, isVisited, tmp, depth + 1);
            }
        }
    }
}
