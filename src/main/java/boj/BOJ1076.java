package boj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ1076 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("black", 0);
        map.put("brown", 1);
        map.put("red", 2);
        map.put("orange", 3);
        map.put("yellow", 4);
        map.put("green", 5);
        map.put("blue", 6);
        map.put("violet", 7);
        map.put("grey", 8);
        map.put("white", 9);

        Scanner sc  = new Scanner(System.in);
        String tens = sc.next();
        String ones = sc.next();
        String trailZero = sc.next();
        int result = (map.get(tens) * 10 + map.get(ones));
        System.out.print(result);
        for (int i = 0; i < map.get(trailZero); i++) {
            System.out.print(0);
        }
    }

}
