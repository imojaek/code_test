import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int y, x;
    static int[][] map;
    static int result = 0;
    static int[][][] tetrominos = {
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}}, // ㅣ
            {{0, 0}, {1, 0}, {0, 1}, {1, 1}}, // ㅁ
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}}, // ㄴ
            {{0, 0}, {0, 1}, {0, 2}, {-1, 2}},
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}}, // ㄹ
            {{0, 0}, {0, 1}, {-1, 1}, {-1, 2}},
            {{-1, 0}, {0, 0}, {1, 0}, {0, 1}} // ㅗ
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new int[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func();
        System.out.println(result);
    }

    public static void func() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                for (int[][] tetromino : tetrominos) {
                    calcAllRotate(j, i, tetromino);
                }
            }
        }
    }

    // 모든 회전을 계산에 넣기
    public static void calcAllRotate(int startX, int startY, int[][] tetromino) {
        int[][] rotatedTetromino = new int[4][2];
        // x, y
        for (int i = 0; i < 4; i++) {
            rotatedTetromino[i][0] = tetromino[i][0];
            rotatedTetromino[i][1] = tetromino[i][1];
        }
        calcTetromino(startX, startY, rotatedTetromino);
        // y, -x
        for (int i = 0; i < 4; i++) {
            rotatedTetromino[i][0] = tetromino[i][1];
            rotatedTetromino[i][1] = -tetromino[i][0];
        }
        calcTetromino(startX, startY, rotatedTetromino);
        // -x, -y
        for (int i = 0; i < 4; i++) {
            rotatedTetromino[i][0] = -tetromino[i][0];
            rotatedTetromino[i][1] = -tetromino[i][1];
        }
        calcTetromino(startX, startY, rotatedTetromino);
        // -y, x
        for (int i = 0; i < 4; i++) {
            rotatedTetromino[i][0] = -tetromino[i][1];
            rotatedTetromino[i][1] = tetromino[i][0];
        }
        calcTetromino(startX, startY, rotatedTetromino);
    }

    // 계산
    public static void calcTetromino(int startX, int startY, int[][] tetromino) {
        int tmp = 0;
        for (int i = 0; i < 4; i++) {
            int px = startX + tetromino[i][0];
            int py = startY + tetromino[i][1];
            if (px < 0 || px >= x || py < 0 || py >= y) {
                return;
            }
            tmp += map[py][px];
        }
        if (result < tmp) {
            result = tmp;
        }
    }
}
