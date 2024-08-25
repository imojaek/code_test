import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();

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
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        StringBuilder sb = new StringBuilder();
        boolean[] isVisited = new boolean[n + 1];
        dfs(start, graph, isVisited, sb);
        sb.setLength(sb.length() - 1);
        System.out.println(sb);

        sb.setLength(0);
        isVisited = new boolean[n + 1];
        bfs(start, graph, isVisited, sb);
        sb.setLength(sb.length() - 1);
        System.out.println(sb);

    }

    public static void dfs(int node, List<List<Integer>> graph, boolean[] isVisited, StringBuilder sb) {
        isVisited[node] = true;
        sb.append(node).append(" ");

        for (int currentPoint : graph.get(node)) {
            if (!isVisited[currentPoint]) {
                dfs(currentPoint, graph, isVisited, sb);
            }
        }
    }

    public static void bfs(int node, List<List<Integer>> graph, boolean[] isVisited, StringBuilder sb) {
        List<Integer> queue = new LinkedList<>();
        isVisited[node] = true;
        queue.add(node);

        while (!queue.isEmpty()) {
            int currentPoint = queue.remove(0);
            sb.append(currentPoint).append(" ");

            for (int point : graph.get(currentPoint)) {
                if (!isVisited[point]) {
                    isVisited[point] = true;
                    queue.add(point);
                }
            }
        }
    }
}
