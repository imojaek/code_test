import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> truckQueue = new LinkedList<>();
        for (int truck : truck_weights) {
            truckQueue.add(truck);
        }
        Queue<int[]> bridgeQueue = new LinkedList<>();

        int currentWeight = 0;
        int time = 1;

        while (!truckQueue.isEmpty()) {
            // 도착한 트럭이 있는지 확인하고 다리 비우기
            if (!bridgeQueue.isEmpty()) {
                int[] firstTruck = bridgeQueue.peek();
                if (firstTruck[1] == time) {
                    currentWeight -= firstTruck[0];
                    bridgeQueue.poll();
                }
            }

            // 다리에 트럭 추가
            int currentTruck = truckQueue.peek();
            if (currentWeight + currentTruck <= weight) {
                truckQueue.poll();
                // 트럭 추가 후 트럭큐가 비어있으면 정답 도출 가능.
                if (truckQueue.isEmpty()) {
                    answer = time + bridge_length;
                    break;
                }
                currentWeight += currentTruck;
                bridgeQueue.add(new int[]{currentTruck, time + bridge_length});
            }

            time++;
        }

        return answer;
    }
}