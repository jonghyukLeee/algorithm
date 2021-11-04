package Etc.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Curve
{
    int x,y,dir,gen;

    public Curve(int x, int y, int dir, int gen)
    {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.gen = gen;
    }
}
public class Q15685 {
    static boolean [][] map;
    static List<Curve> input;
    static int answer = 0;
    static int [] dx = {0,-1,0,1};
    static int [] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new boolean[101][101];
        input = new ArrayList<>();

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < t; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int gen = Integer.parseInt(st.nextToken());

            input.add(new Curve(x,y,dir,gen));
        }

        List<Integer> dir_list;
        for(Curve c : input)
        {
            dir_list = new ArrayList<>();
            dir_list.add(c.dir);
            for(int i = 0; i < c.gen; ++i)
            {
                for(int j = dir_list.size()-1; j >= 0; --j)
                {
                    dir_list.add((dir_list.get(j)+1) % 4);
                }
            }
            curve(c,dir_list);
        }
        countSquare();
        System.out.print(answer);
    }
    static void curve(Curve c, List<Integer> list)
    {
        int x = c.x;
        int y = c.y;
        map[x][y] = true;
        for(int dir : list)
        {
            x += dx[dir];
            y += dy[dir];
            map[x][y] = true;
        }
    }
    static void countSquare()
    {
        for(int i = 0; i < 100; ++i)
        {
            for(int j = 0; j < 100; ++j)
            {
                if(map[i][j])
                {
                    if(map[i][j+1] && map[i+1][j+1] && map[i+1][j]) answer++;
                }
            }
        }
    }
}
