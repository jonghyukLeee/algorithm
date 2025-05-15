import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int num = 0;
            if (!command.equals("all") && !command.equals("empty")) {
                num = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case "all":
                case "empty": {
                    set.clear();
                    if (command.equals("all")) {
                        for (int i = 1; i <= 20; i++) set.add(i);
                    }
                    break;
                }
                case "add": {
                    set.add(num);
                    break;
                }
                case "remove": {
                    set.remove(num);
                    break;
                }
                case "check": {
                    sb.append(set.contains(num) ? "1" : "0").append("\n");
                    break;
                }
                case "toggle": {
                    if (set.contains(num)) {
                        set.remove(num);
                    } else {
                        set.add(num);
                    }
                    break;
                }
            }
        }

        if (sb.length() > 1) sb.deleteCharAt(sb.length() - 1); 
        System.out.print(sb);
    }
}
