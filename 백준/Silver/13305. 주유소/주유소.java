import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, price;
    static int [] roads, oils;
    static boolean isDone;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()) - 1;

        roads = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) roads[i] = Integer.parseInt(st.nextToken());

        oils = new int[N]; // 마지막은 버려도됨
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) oils[i] = Integer.parseInt(st.nextToken());

        int idx = 0, currentOil = 0;
        while (idx < N) {
            if (isDone) break;
            if (currentOil < roads[idx]) currentOil = fill(idx, currentOil);
            currentOil -= roads[idx++];
        }
        System.out.print(price);
    }

    static int fill(int idx, int currentOil) {
        int amount = roads[idx];
        int nextStation = idx + 1;

        while (nextStation < N) {
            if (oils[idx] < oils[nextStation]) amount += roads[nextStation];
            else break;
            if (nextStation == N - 1) isDone = true;
            nextStation++;
        }
        price += oils[idx] * amount;

        return currentOil + amount;
    }
}
