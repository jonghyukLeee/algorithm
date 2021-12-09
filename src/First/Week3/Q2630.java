package First.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2630 {
    static int [][] map;
    static int wCnt = 0;
    static int bCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i  = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        countPaper(0,0,n);
        System.out.printf("%d\n%d",wCnt,bCnt);
    }
    static void countPaper(int row, int col, int size)
    {
        if(checkColor(row,col,size))
        {
            if(map[row][col] == 1) bCnt++;
            else wCnt++;
            return;
        }
        int changeSize = size/2;
        countPaper(row,col,changeSize);
        countPaper(row,col+changeSize,changeSize);
        countPaper(row+changeSize,col,changeSize);
        countPaper(row+changeSize,col+changeSize,changeSize);
    }
    static boolean checkColor(int row, int col, int size)
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
