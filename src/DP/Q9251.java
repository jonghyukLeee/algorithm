package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9251 {
    static int [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp1 = br.readLine();
        String tmp2 = br.readLine();

        String [] fst = tmp1.split("");
        String [] sec = tmp2.split("");
        dp = new int[fst.length][fst.length];

    }
}
