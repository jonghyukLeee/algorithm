package Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1780 {
    static int [][] map;
    static int cntMinus = 0, cntZero = 0, cntOne = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        paper(0,0,n);
        System.out.printf("%d\n%d\n%d",cntMinus,cntZero,cntOne);
        br.close();
    }
    static void paper(int row, int col, int size)
    {
        if(check(row,col,size))
        {
            switch(map[row][col])
            {
                case -1:
                {
                    cntMinus++;
                    break;
                }
                case 0:
                {
                    cntZero++;
                    break;
                }
                case 1:
                {
                    cntOne++;
                    break;
                }
            }
        }
        else
        {
            int cSize = size/3;
            paper(row,col,cSize);
            paper(row,col+cSize,cSize);
            paper(row,col+(cSize*2),cSize);
            paper(row+cSize,col,cSize);
            paper(row+cSize,col+cSize,cSize);
            paper(row+cSize,col+(cSize*2),cSize);
            paper(row+(cSize*2),col,cSize);
            paper(row+(cSize*2),col+cSize,cSize);
            paper(row+(cSize*2),col+(cSize*2),cSize);
        }
    }
    static boolean check(int row, int col, int size)
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
