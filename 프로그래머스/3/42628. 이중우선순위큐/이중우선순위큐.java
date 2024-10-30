import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> b - a);

        for (String op : operations) {
            String command = op.split(" ")[0];
            int value = Integer.parseInt(op.split(" ")[1]);

            if (command.equals("I")) {
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
            else if (command.equals("D")) {
                if (map.isEmpty())
                    continue;

                if (value == 1) {
                    int firstKey = map.firstKey();
                    if (map.get(firstKey) > 1)
                        map.put(firstKey, map.get(firstKey) - 1);
                    else
                        map.remove(firstKey);
                }
                else if (value == -1) {
                    int lastKey = map.lastKey();
                    if (map.get(lastKey) > 1)
                        map.put(lastKey, map.get(lastKey) - 1);
                    else
                        map.remove(lastKey);
                }
                else
                    System.out.println("...?");
            }
        }

        if (map.isEmpty())
            return new int[]{0, 0};
        return new int[]{map.firstKey(), map.lastKey()};
    }
}