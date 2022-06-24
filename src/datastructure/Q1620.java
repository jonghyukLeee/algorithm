package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> hm = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            hm.put(String.valueOf(i),input);
            hm.put(input,String.valueOf(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            sb.append(hm.get(input)).append("\n");
        }
        System.out.print(sb);
    }
}
