package Etc.pack1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Point
{
    int x;
    int y;
    int val;
    int dir;

    public Point(int x, int y, int val, int dir) {
        this.x = x;
        this.y = y;
        this.val = val;
        this.dir = dir;
    }
}
public class Q1913 {
    static int N;
    static int [][] map;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];


        Point snail = new Point(N/2,N/2,1,0);

        while(true)
        {
            map[snail.x][snail.y] = snail.val;

            int dir = isWall(snail);

            int mx = snail.x + dx[snail.dir];
            int my = snail.y + dy[snail.dir];
        }
    }
    static int isWall(Point snail)
    {
        int mx = snail.x + dx[snail.dir];
        int my = snail.y + dy[snail.dir];

        return isValid(mx,my) ? snail.dir : (snail.dir + 1) % 4;
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
