package Etc.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17825 {
    static int [] dice;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dice = new int[10];
        for(int i = 0; i < 10; ++i)
        {
            dice[i] = Integer.parseInt(st.nextToken());
        }


    }
}
