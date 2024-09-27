import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, m;
    static int[][] arr;
    static int startX, startY;

    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                if (input[j].equals("2")) {
                    startX = i;
                    startY = j;
                    arr[i][j] = 0;
                }
                else if (input[j].equals("0")) {
                    arr[i][j] = 0;
                }
                else {
                    arr[i][j] = -1;
                }
            }
        }

        func(startX, startY);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void func(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        visited[startX][startY] = true;
        queue.add(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] currentPos = queue.poll();
            int x = currentPos[0];
            int y = currentPos[1];

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY] && arr[nextX][nextY] != 0) {
                    visited[nextX][nextY] = true;
                    arr[nextX][nextY] = arr[x][y] + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}
