package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Ice
{
    int x,y;

    public Ice(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class Q2573 {
    static int [][] map;
    static boolean [][] isVis;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};
    static Queue<Ice> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        isVis = new boolean[n][m];
        q = new LinkedList<>();

        boolean tmpFlag = true;
        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(tmpFlag)
                {
                    if(map[i][j] > 0)
                    {
                        q.add(new Ice(i,j));
                        isVis[i][j] = true;
                        tmpFlag = false;
                    }
                }
            }
        }
        year();


    }
    static void year()
    {
        while(!q.isEmpty())
        {
            Ice tmpIce = q.poll();

            for(int idx = 0; idx < 4; ++idx)
            {
                int x = tmpIce.x + dx[idx];
                int y = tmpIce.y + dy[idx];

                if(!isValid(x,y) || isVis[x][y]) continue;

                if(map[x][y] <= 0)
                {
                    map[tmpIce.x][tmpIce.y]--;
                    continue;
                }
                q.add(new Ice(x,y));
                isVis[x][y] = true;

            }
        }
    }
    // 물 만났을시 -1 까지 완료 , 전체 배열 체크후 방문하지않았지만 0보다 큰 빙하를 발견하면 분리됐다고 판단하고
    // 시간값을 리턴. (시간체크하는 변수도 아직)

    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length;
    }
}
