import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        long A = Long.parseLong(split[0]);
        long B = Long.parseLong(split[1]);
        long C = Long.parseLong(split[2]);

        long result = modular(A, B, C);
        System.out.println(result);
    }

    public static long modular(long a, long b, long c) {
        if (b == 0) {
            return 1;
        }

        long tmp = modular(a, b / 2, c);
        tmp = (tmp * tmp) % c;

        if (b % 2 == 1) {
            tmp = (tmp * a) % c;
        }

        return tmp;
    }
}