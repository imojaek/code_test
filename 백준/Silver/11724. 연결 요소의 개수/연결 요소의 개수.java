import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
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
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) { // 점 하나만 있는 것도 연결요소인가?
                result++;
                func(i, graph, isVisited);
            }
        }
        System.out.println(result);
    }

    public static void func(int node, List<List<Integer>> graph, boolean[] isVisited) {
        isVisited[node] = true;
        for (int currentPoint : graph.get(node)) {
            if (!isVisited[currentPoint]) {
                func(currentPoint, graph, isVisited);
            }
        }
        return ;
    }
}
