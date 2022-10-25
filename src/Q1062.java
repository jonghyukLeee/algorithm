import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1062 {
    static int N,K;
    static boolean [] isLearned;
    static List<String> dic;
    static int answer;
    static int learnCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        isLearned = new boolean[26];
        // a, c, i, n, t는 기본으로 배워야함
        isLearned[0] = true;
        isLearned[2] = true;
        isLearned[8] = true;
        isLearned[13] = true;
        isLearned[19] = true;

        learnCount = K - 5;
        if (learnCount >= 0) {
            dic = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                // anta, tica 자름
                String str = input.substring(4, input.length() - 4);
                dic.add(str);
            }
            dfs(0,0);
        }
        System.out.print(answer);
    }
    static void dfs(int start, int count) {
        if (count == learnCount) {
            answer = Math.max(answer, readDic());
            return;
        }
        for (int i = start; i < 26; i++) {
            if (!isLearned[i]) {
                isLearned[i] = true;
                dfs(i, count + 1);
                isLearned[i] = false;
            }
        }
    }
    static int readDic() {
        int tmp = 0;
        next : for (String str : dic) {
            int strLen = str.length();
            for (int i = 0; i < strLen; i++) {
                if (!isLearned[str.charAt(i) - 97]) continue next;
            }
            tmp++;
        }
        return tmp;
    }
}
