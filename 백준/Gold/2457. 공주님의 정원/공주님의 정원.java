import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Flower> pqstart = new PriorityQueue<>((a, b) -> {
                    if (a.start.month != b.start.month) {
                        return a.start.month - b.start.month;
                    } else {
                        return a.start.day - b.start.day;
                    }
                }
        );

        PriorityQueue<Flower> pqend = new PriorityQueue<>((a, b) -> {
            if (a.end.month != b.end.month) {
                return b.end.month - a.end.month;
            } else {
                return b.end.day - a.end.day;
            }
        });

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            pqstart.offer(new Flower(
                    new Day(Integer.parseInt(input[0]), Integer.parseInt(input[1])),
                    new Day(Integer.parseInt(input[2]), Integer.parseInt(input[3]))));
        }

        int currentMonth = 3;
        int currentDay = 1;
        int result = 0;
        boolean flag = false;

        while (currentMonth <= 11) {
            while (true) {
                Flower flower = pqstart.peek();
                if (flower == null) break;
                if (flower.start.month > currentMonth || flower.start.month == currentMonth && flower.start.day > currentDay) {
                    break;
                }
                pqstart.poll();
                pqend.offer(flower);
            }

            Flower selectFlower = pqend.poll();
            if (selectFlower == null) {
                System.out.println("0");
                flag = true;
                break;
            }
            result++;
            currentMonth = selectFlower.end.month;
            currentDay = selectFlower.end.day;

            pqend.clear();
        }
        if (!flag)
            System.out.println(result);

    }

    public static class Flower {
        Day start;
        Day end;

        public Flower(Day start, Day end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class Day {

        int month;
        int day;

        public Day(int month, int day) {
            this.month = month;
            this.day = day;
        }
    }
}
