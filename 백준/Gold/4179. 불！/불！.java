import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static Queue<Point> queue = new LinkedList<>();
    static Point jihoon;
    static int result;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] isVisited;
    static boolean[][] isVisitedByFire;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        isVisited = new boolean[n][m];
        isVisitedByFire = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                switch (line.charAt(j)) { // 벽과 빈공간을 위에.
                    case '.':
                        map[i][j] = Integer.MAX_VALUE;
                        break;
                    case '#':
                        map[i][j] = Integer.MIN_VALUE;
                        break;
                    case 'F':
                        map[i][j] = 1;
                        queue.add(new Point(i, j));
                        isVisitedByFire[i][j] = true;
                        break;
                    case 'J':
                        map[i][j] = 0;
                        jihoon = new Point(i, j);
                        isVisited[i][j] = true;
                        break;

                }
            }
        }

        // 불을 먼저 퍼트려서 불이 퍼지는 시간을 맵에 기록.
        bfsFire(isVisitedByFire);

        // 이제 지훈이가 가도록.
        queue.add(jihoon);
        isVisited[jihoon.x][jihoon.y] = true;
        map[jihoon.x][jihoon.y] = 1;
        bfsJihoon(isVisited);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfsFire(boolean[][] isVisited) {
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !isVisited[nextX][nextY]
                        && map[nextX][nextY] != Integer.MIN_VALUE) {
                    map[nextX][nextY] = map[current.x][current.y] + 1;
                    isVisited[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY));
                }
            }
        }
    }

    static void bfsJihoon(boolean[][] isVisited) {
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.x == 0 || current.x == n - 1 || current.y == 0 || current.y == m - 1) {
                System.out.println(map[current.x][current.y]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];
                int turn = map[current.x][current.y] + 1;

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !isVisited[nextX][nextY]
                        && map[nextX][nextY] != Integer.MIN_VALUE
                        && turn < map[nextX][nextY]) { // 불이 퍼지지 않은 순간까지만 이동 가능
                    map[nextX][nextY] = turn;
                    isVisited[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY));
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
