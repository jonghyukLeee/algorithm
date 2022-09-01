import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> al = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                al.add(Integer.parseInt(st.nextToken()));
            }
        }
        al.sort(Collections.reverseOrder());
        System.out.print(al.get(N - 1));
    }
}
