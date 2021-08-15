package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Land
{
    int x,y,time;

    public Land(int x, int y, int time)
    {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
public class Q2589 {
    static char [][] map;
    static Queue<Land> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for(int i = 0; i < n; ++i)
        {
            String tmpStr = br.readLine();
            for(int j = 0; j < m; ++j)
            {
                map[i][j] = tmpStr.charAt(j);
            }
        }

        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < m; ++j)
            {
                if(map[i][j] == 'L')
                {
                    q.add(new Land(i,j,0));
                    break;
                }
            }
        }

    }

}
