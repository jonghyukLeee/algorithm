package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String [] input = new String[n];
            for (int i = 0; i < n; i++) {
                input[i] = br.readLine();
            }

            Arrays.sort(input);
            sb.append(check(input)).append("\n");
        }

        System.out.print(sb);
    }
    static String check(String [] arr){
        int size = arr.length - 1;

        for (int i = 0; i < size; i++) {
            String cur = arr[i];
            if (arr[i + 1].startsWith(cur)) return "NO";
        }

        return "YES";
    }
}
