package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13305 {
    static int N;
    static long price;
    static long [] roads, oils;
    static boolean isDone;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()) - 1;

        roads = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) roads[i] = Long.parseLong(st.nextToken());

        oils = new long[N]; // 마지막은 버려도됨
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) oils[i] = Long.parseLong(st.nextToken());

        /**
         * 첫 번째 풀이
         */
//        int idx = 0, currentOil = 0;
//        while (idx < N) {
//            if (isDone) break;
//            if (currentOil < roads[idx]) currentOil = fill(idx, currentOil);
//            currentOil -= roads[idx++];
//        }

        for (int i = 0; i < N - 1; i++) {
            if (oils[i] < oils[i + 1]) oils[i + 1] = oils[i];
            price += (roads[i] * oils[i]);
        }
        price += (roads[N - 1] * oils[N - 1]); // 마지막 도시

        System.out.print(price);
    }

//    static int fill(int idx, int currentOil) {
//        int amount = roads[idx];
//        int nextStation = idx + 1;
//
//        while (nextStation < N) {
//            if (oils[idx] < oils[nextStation]) amount += roads[nextStation];
//            else break;
//            if (nextStation == N - 1) isDone = true;
//            nextStation++;
//        }
//        price += oils[idx] * amount;
//
//        return currentOil + amount;
//    }
}
