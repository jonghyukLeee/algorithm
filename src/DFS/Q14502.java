package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point
{
    int x,y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class Q14502 {
    static final int BLANK = 0;
    static final int WALL = 1;
    static final int VIRUS = 2;
    static ArrayList<Point> origin;
    static boolean [][] isVis;
    static int [][] copyMap;
    static int n,m,safetyZone = Integer.MIN_VALUE;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};

    static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        copyMap = new int[n][m];
        isVis = new boolean[n][m];
        origin = new ArrayList<>();

        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == VIRUS)
                {
                    origin.add(new Point(i,j));
                }
            }
        }

        build(0);
        System.out.print(safetyZone);
    }
    static void build(int cnt)
    {
        if(cnt == 3)
        {
            spread();
            return;
        }

        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < m; ++j)
            {
                if(map[i][j] == BLANK)
                {
                    map[i][j] = WALL;
                    build(cnt+1);
                    map[i][j] = BLANK;
                }
            }
        }
    }
    static void spread()
    {
        Queue<Point> q = new LinkedList<>();
        for(int idx = 0; idx < n; ++idx)
        {
            System.arraycopy(map[idx],0,copyMap[idx],0,map[0].length);
        }
        if(!origin.isEmpty())
        {
            q.addAll(origin);
        }

        while(!q.isEmpty())
        {
            Point tmp = q.poll();

            for(int idx = 0; idx < 4; ++idx)
            {
                int x = tmp.x + dx[idx];
                int y = tmp.y + dy[idx];
                if(!isValid(x,y)) continue;
                if(copyMap[x][y] == BLANK)
                {
                    q.add(new Point(x,y));
                    copyMap[x][y] = 2;
                }
            }
        }
        safetyZone = Math.max(safetyZone,isSafety());
    }
    static int isSafety()
    {
        int tmpValue = 0;
        for(int [] i : copyMap)
        {
            for(int j : i)
            {
                if(j == 0) tmpValue++;
            }
        }
        return tmpValue;
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length;
    }
}
