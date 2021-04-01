package Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4179 {
    static char [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for(int i = 0; i < n; ++i)
        {
            String str = br.readLine();
            for(int j = 0; j < m; ++j)
            {
                char tmp = str.charAt(j);
                map[i][j] = tmp;
//                if(tmp == 'J')
//                {
//
//                }
            }
        }
    }
}

class Point2
{
    int x,y;
    public Point2(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}