import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "add": {
                    int x = Integer.parseInt(st.nextToken());
                    answer |= 1 << x;
                    break;
                }
                case "remove": {
                    int x = Integer.parseInt(st.nextToken());
                    answer &= ~(1 << x);
                    break;
                }
                case "check": {
                    int x = Integer.parseInt(st.nextToken());
                    sb.append((answer & (1 << x)) != 0 ? 1 : 0).append("\n");
                    break;
                }
                case "toggle": {
                    int x = Integer.parseInt(st.nextToken());
                    answer ^= 1 << x;
                    break;
                }
                case "all": {
                    answer = (1 << 21) - 1;
                    break;
                }
                case "empty": {
                    answer = 0;
                    break;
                }
            }
        }
        if(sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        System.out.print(sb);
    }
}
