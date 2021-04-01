package Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1926 {
    static int [][] map;
    static boolean [][] isVis;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Point> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isVis = new boolean[n][m];
        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int size = 0; // 그림의 최댓값
        int cnt = 0; // 그림의 갯수

        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < m; ++j)
            {
                if(isVis[i][j] || map[i][j] == 0) continue;
                cnt++;
                int tmpSize = 1;
                q.add(new Point(i,j));
                isVis[i][j] = true;
                while(!q.isEmpty())
                {
                    Point p = q.poll();
                    for(int k = 0; k < 4; ++k)
                    {
                        int tx = p.x + dx[k];
                        int ty = p.y + dy[k];
                        if(tx < 0 || ty < 0 || tx >= map.length || ty >= map[0].length) continue;
                        if(isVis[tx][ty] || map[tx][ty] == 0) continue;
                        tmpSize++;
                        q.add(new Point(tx,ty));
                        isVis[tx][ty] = true;
                    }
                }
                size = Math.max(size,tmpSize);
            }
        } // end of loop
        System.out.printf("%d\n%d",cnt,size);
    }
}
class Point
{
    int x,y;
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
