import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = 0;

    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    /*
        bfs로 탐색하면서 내리막길인 것들을 전부 큐에 등록하고, 마지막 지점에 도착할 때마다 result++
        내리막인 길만 등록하니까 isVisited를 추가하지 않아도 루프가 생기지 않을 것으로 기대.
     */

    // 방문기록을 추가하지 않았을 때 루프가 생기지는 않았다. 하지만 모든 경우의수를 체크하기 때문에 시간초과.

    static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (arr[nx][ny] < arr[x][y]) {
                    dp[x][y] += dfs(nx, ny);
                }
            }
        }

        return dp[x][y];
    }
}