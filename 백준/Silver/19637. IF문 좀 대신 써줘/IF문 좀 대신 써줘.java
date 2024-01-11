import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Title_19637 {
    String name;
    int minimumPower;

    public Title_19637(String name, int minimumPower) {
        this.name = name;
        this.minimumPower = minimumPower;
    }
}
public class Main {
    static int N, M;
    static Title_19637 [] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Title_19637[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());

            map[i] = new Title_19637(name, power);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int currentPower = Integer.parseInt(br.readLine());

            sb.append(getTitleName(currentPower)).append("\n");
        }

        System.out.print(sb.deleteCharAt(sb.length() - 1));
    }

    public static String getTitleName(int power) {
        String titleName = map[0].name;
        int start = 0, end = N - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (power <= map[mid].minimumPower) {
                titleName = map[mid].name;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return titleName;
    }
}
