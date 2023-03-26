import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char [] s = br.readLine().toCharArray();
        int answer = 0;
        int oiLen = 2 * n;
        for (int i = 1; i <= m - oiLen; i++) {
            char cur = s[i];

            // O로 시작하면 목표로한 OI 길이만큼 탐색
            if (cur == 'O') {
                boolean isOi = true;
                for (int j = i; j < i + oiLen - 1; j++) {
                    if (s[j] == s[j + 1]) {
                        isOi = false; // 연속된 문자가 동일하다면 OI 성립 x
                        break;
                    }
                }
                if (isOi) {
                    // OI 규칙을 만족하면서 시작값 앞 인덱스가 I라면 카운트++
                    if (s[i - 1] == 'I') answer++;
                }
            }
        }
        System.out.print(answer);
    }
}
