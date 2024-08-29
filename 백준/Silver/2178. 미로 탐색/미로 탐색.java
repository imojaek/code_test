import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] maze;

    static int n;
    static int m;

    static int[][] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        isVisited  = new int[n][m];

        bfs(0,0);

        System.out.println(maze[n - 1][m - 1]);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        isVisited[x][y] = 1;



        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            int currentX = currentPoint.x;
            int currentY = currentPoint.y;

            if (currentX == n - 1 && currentY == m - 1) {
                return ;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m
                        && isVisited[nextX][nextY] == 0 && maze[nextX][nextY] == 1) {
                    isVisited[nextX][nextY] = 1;
                    maze[nextX][nextY] = maze[currentX][currentY] + 1;
                    queue.add(new Point(nextX, nextY));
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
