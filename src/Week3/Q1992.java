package Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1992 {
    static int [][] map;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; ++i)
        {
            s = br.readLine();
            for(int j = 0; j < n; ++j)
            {
                map[i][j] = s.charAt(j)-'0';
            }
        }
        quad(0,0,n);
        System.out.print(sb.toString());
    }
    static void quad(int row, int col, int size)
    {
        if(checkMap(row,col,size))
        {
            sb.append(map[row][col]);
        }
        else
        {
            int cSize = size/2;
            sb.append("(");
            quad(row,col,cSize);
            quad(row,col+cSize,cSize);
            quad(row+cSize,col,cSize);
            quad(row+cSize,col+cSize,cSize);
            sb.append(")");
        }
    }
    static boolean checkMap(int row, int col, int size)
    {
        int tmp = map[row][col];
        for(int i = row; i < row+size; ++i)
        {
            for(int j = col; j < col+size; ++j)
            {
                if(tmp != map[i][j]) return false;
            }
        }
        return true;
    }
}
