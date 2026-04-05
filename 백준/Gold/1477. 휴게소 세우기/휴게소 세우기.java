import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, L;
    static List<Integer> origin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        origin = new ArrayList<>();
        origin.add(0);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            origin.add(Integer.parseInt(st.nextToken()));
        }
        origin.add(L);

        Collections.sort(origin);

        int start = 1;
        int end = L - 1;
        int result = L;
        while(start <= end) {
            int mid = (start + end) / 2;

            int count = 0;
            for(int i = 1; i < origin.size(); i++) {
                int diff = origin.get(i) - origin.get(i - 1);
                count += (diff - 1) / mid;
            }

            if(count > M) start = mid + 1;
            else {
                result = Math.min(result, mid);
                end = mid - 1;
            }
        }

        System.out.print(result);
    }
}
