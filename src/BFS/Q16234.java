package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Country
{
    int x,y;
    public Country(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class Q16234 {

    static int l,r,n;
    static int [][] map;
    static boolean [][] isVis;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {1,-1,0,0};
    static int flag = 1;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(flag == 1)
        {
            flag = 0;
            answer++;
            isVis = new boolean[n][n];
            for(int i = 0; i < n; ++i)
            {
                for(int j = 0; j < n; ++j)
                {
                    if(isVis[i][j]) continue;
                    isVis[i][j]= true;
                    move(i,j);
                }
            }
        }
        System.out.print(answer);

    }
    static void move(int i, int j)
    {
        Queue<Country> q = new LinkedList<>();
        q.add(new Country(i,j));
        ArrayList<Country> al = new ArrayList<>();
        al.add(new Country(i,j));
        while(!q.isEmpty())
        {
            Country tmp = q.poll();
            int preX = tmp.x;
            int preY = tmp.y;
            for(int idx = 0; idx < 4; ++idx)
            {
                int x = preX + dx[idx];
                int y = preY + dy[idx];

                if(!isValid(x,y) || isVis[x][y]) continue;
                int gap = Math.abs(map[preX][preY] - map[x][y]);
                if(gap < l || r < gap) continue;
                isVis[x][y] = true;
                q.add(new Country(x,y));
                al.add(new Country(x,y));
            }
        }
        calc(al);

    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length;
    }
    static void calc(ArrayList<Country> al)
    {
        if(al.size() == 1) return;
        flag = 1;
        double res = 0;

        for(Country tmp : al)
        {
            res += map[tmp.x][tmp.y];
        }
        res = Math.floor(res / al.size());
        for(Country tmp : al)
        {
            map[tmp.x][tmp.y] = (int)res;
        }
    }
}
