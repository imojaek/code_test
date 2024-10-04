import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 진실을 아는 멤버
        st = new StringTokenizer(br.readLine());
        int knownCount = Integer.parseInt(st.nextToken());
        List<Integer> knownPeople = new ArrayList<>();
        for (int i = 0; i < knownCount; i++) {
            knownPeople.add(Integer.parseInt(st.nextToken()));
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < partySize; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);

            for (int j = 1; j < party.size(); j++) {
                union(party.get(0), party.get(j));
            }
        }

        // 마지막으로 진실을 아는 멤버들을 묶음
        int knownParent = knownPeople.isEmpty() ? -1 : find(knownPeople.get(0));
        for (int person : knownPeople) {
            union(knownParent, person);
        }

        // 거짓말이 가능한지 확인
        int liePartyCount = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (find(person) == knownParent) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) {
                liePartyCount++;
            }
        }

        System.out.println(liePartyCount);
    }
}
