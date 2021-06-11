package Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2959 {
    static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] input = new int[4];
        map = new int[100][100];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; ++i)
        {
            input[i] = Integer.parseInt(st.nextToken());
        }
        
    }
}
