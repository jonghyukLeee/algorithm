package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Tomato
{
    int x,y,z;
    public Tomato(int x, int y,int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class Q7569 {
    static int [][][] map;
    static boolean [][][] isVis;
    static ArrayList<Integer> maxAl;
    static int day = 0;
    static int [] dz = {0,0,0,0,1,-1}; // 상 하 좌 우 전 후
    static int [] dy = {0,0,-1,1,0,0};
    static int [] dx = {1,-1,0,0,0,0};
    static Queue<Tomato> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); //5
        int n = Integer.parseInt(st.nextToken()); //3
        int h = Integer.parseInt(st.nextToken()); //2
        boolean check = true;

        map = new int[h][n][m]; // [2][3][5]
        isVis = new boolean[h][n][m];
        q = new LinkedList<>();
        maxAl = new ArrayList<>();

        for(int i  = 0; i < h; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; ++k)
                {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] > 0)
                    {
                        q.add(new Tomato(j,k,i));
                        isVis[i][j][k] = true;
                    }
                    else if(map[i][j][k] < 0) isVis[i][j][k] = true;
                    else if(map[i][j][k] == 0) check = false;
                }
            }
        }
        if(check)
        {
            System.out.print(day);
            return;
        }
        bfs();

        maxAl.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        if(hasBlank()) day = -1;
        else
        {
            day = maxAl.get(0) - 1;
        }
        System.out.print(day);
    }
    static void bfs()
    {
        while(!q.isEmpty())
        {
            Tomato tmpQ = q.poll();
            for(int idx = 0; idx < 6; ++idx)
            {
                int x = tmpQ.x + dx[idx];
                int y = tmpQ.y + dy[idx];
                int z = tmpQ.z + dz[idx];

                if(!isValid(z,x,y) || isVis[z][x][y]) continue;
                isVis[z][x][y] = true;
                q.add(new Tomato(x,y,z));
                map[z][x][y] = map[tmpQ.z][tmpQ.x][tmpQ.y] + 1;
                maxAl.add(map[z][x][y]);
            }
        }
    }
    static boolean isValid(int z, int x, int y)
    {
        return x >= 0 && y >= 0 && z >= 0 && x < map[0].length && y < map[0][0].length && z < map.length;
    }
    static boolean hasBlank()
    {
        for(int [][] i : map)
        {
            for(int [] j : i)
            {
                for(int k : j)
                {
                    if(k == 0) return true;
                }
            }
        }
        return false;
    }
}
