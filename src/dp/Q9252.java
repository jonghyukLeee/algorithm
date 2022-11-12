package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();

        char [] arr1 = new char[len1 + 1];
        char [] arr2 = new char[len2 + 1];

        for (int i = 0; i < len1; i++) arr1[i + 1] = str1.charAt(i);

        for (int i = 0; i < len2; i++) arr2[i + 1] = str2.charAt(i);

        int [][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        int lcs = dp[len1][len2];
        answer.append(lcs).append("\n");
        if (lcs > 0) {
            int i = len1, j = len2;
            Stack<Character> stk = new Stack<>();
            while (i > 0 && j > 0) {
                int cur = dp[i][j];
                if (cur == dp[i - 1][j]) {
                    i--;
                }
                else if (cur == dp[i][j - 1]) {
                    j--;
                }
                else {
                    stk.add(arr1[i]);
                    i--;
                    j--;
                }
            }
            while(!stk.isEmpty()) {
                answer.append(stk.pop());
            }
        }
        System.out.print(answer);
    }
}
