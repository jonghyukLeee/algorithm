import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> line = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        P = Integer.parseInt(br.readLine());
        for (int i = 1; i <= P; i++) {
            sb.append(i).append(" ");

            line.clear();
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();

            while (st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken());

                int insertIndex = 0;

                for (int height: line) {
                    if (next < height) {
                        answer += line.size() - insertIndex;
                        break;
                    }
                    insertIndex++;
                }
                line.add(insertIndex, next);
            }

            sb.append(answer).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
