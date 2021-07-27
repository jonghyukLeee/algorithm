package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Loc
{
    int x,y,time;
    public Loc(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public Loc(int x, int y, int time)
    {
        this.x = x;
        this.y = y;
        this.time = time;
    }
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }
}
public class Q3055 {
    static char [][] map;
    static boolean [][] isVis;
    static Queue<Loc> moveQ;
    static Queue<Loc> waterQ;
    static int answer = 0;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        isVis = new boolean[r][c];
        moveQ = new LinkedList<>();
        waterQ = new LinkedList<>();

        for(int i = 0; i < r; ++i)
        {
            String tmpStr = br.readLine();
            for(int j = 0; j < c; ++j)
            {
                map[i][j] = tmpStr.charAt(j);
                switch(map[i][j])
                {
                    case 'S' :
                    {
                        moveQ.add(new Loc(i,j,0));
                        isVis[i][j] = true;
                        break;
                    }
                    case '*' :
                    {
                        waterQ.add(new Loc(i,j));
                        break;
                    }
                    default : break;
                }
            }
        }
        while(!moveQ.isEmpty())
        {
            ArrayList<Loc> tmpAl = new ArrayList<>();
            while(!moveQ.isEmpty())
            {
                Loc tmp = moveQ.poll();
                int curX = tmp.getX(), curY = tmp.getY();
                if(map[curX][curY] == '*') continue;
                if(map[curX][curY] == 'D')
                {
                    answer = tmp.time;
                    break;
                }
                for(int i = 0; i < 4; ++i)
                {
                    int x = curX + dx[i];
                    int y = curY + dy[i];

                    if(!isValid(x,y) || isVis[x][y] || map[x][y] == '*' || map[x][y] == 'X') continue;
                    isVis[x][y] = true;
                    tmpAl.add(new Loc(x,y,tmp.time+1));
                }
            }
            moveQ.addAll(tmpAl);
            spreadWater(waterQ);
        }
        if(answer == 0)
        {
            System.out.print("KAKTUS");
            return;
        }
        System.out.print(answer);

    }
    static void spreadWater(Queue<Loc> q)
    {
        ArrayList<Loc> tmpAl = new ArrayList<>();
        while(!q.isEmpty())
        {
            Loc tmp = q.poll();
            for(int i = 0; i < 4; ++i)
            {
                int x = tmp.getX() + dx[i];
                int y = tmp.getY() + dy[i];
                if(!isValid(x,y) || map[x][y] == '*' || map[x][y] == 'X' || map[x][y] == 'D') continue;
                map[x][y] = '*';
                tmpAl.add(new Loc(x,y));
            }
        }
        waterQ.addAll(tmpAl);
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length;
    }
}
