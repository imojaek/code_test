import java.util.Scanner;

public class Main {
    static int M;
    static int N;
    static int K;
    static int[][] field;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int t = 0; t < test; t++) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();

            field = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                field[y][x] = 1;
            }
            int numOfQocn = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        numOfQocn++;
                    }
                }
            }

            System.out.println(numOfQocn);
        }
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                if (field[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                    dfs(nextY, nextX);
                }
            }
        }
    }
}
