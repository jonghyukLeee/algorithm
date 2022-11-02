package unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1043 {
    static int N,M;
    static boolean [] truth;
    static List<List<Integer>> party;
    static int [] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        party = new ArrayList<>();

        //진실을 아는 사람 수
        truth = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        int tCount = Integer.parseInt(st.nextToken());

        //아는사람 없으면 출력 후 종료
        if (tCount < 1) {
            System.out.print(M);
            System.exit(0);
        }
        for (int i = 0; i < tCount; i++) {
            int tmpNumber = Integer.parseInt(st.nextToken());
            truth[tmpNumber] = true;
        }

        //자기 자신으로 초기화
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        // 파티
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int tmpCount = Integer.parseInt(st.nextToken());

            List<Integer> partyMember = new ArrayList<>();
            for (int j = 0; j < tmpCount; j++) {
                int memberNumber = Integer.parseInt(st.nextToken());
                partyMember.add(memberNumber);
                if (j > 0) {
                    union(partyMember.get(j - 1), partyMember.get(j));
                }
            }
            party.add(partyMember);
        }

        boolean [] isVisited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (truth[i] && !isVisited[i]) {
                isVisited[i] = true;
                int parent = find(i);

                for (int j = 1; j <= N; j++) {
                    if (parent == find(j)) {
                        truth[j] = true;
                        isVisited[j] = true;
                    }
                }
            }
        }

        int answer = 0;
        next : for (List<Integer> list : party) {
            for (int member : list) {
                // 한명이라도 진실을 알면 다음파티로
                if (truth[member]) continue next;
            }
            answer++;
        }

        System.out.print(answer);
    }
    static int find(int child) {
        return parents[child] == child ? child : find(parents[child]);
    }

    static void union(int p, int c) {
        int parent = find(p);
        int child = find(c);

        if (parent != child) {
            parents[child] = parent;
        }
    }
}
