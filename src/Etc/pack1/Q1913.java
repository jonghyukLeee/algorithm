package Etc.pack1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Point
{
    int x;
    int y;
    int val;
    int dir;
    int mv_cnt;
    int cnt;
    int curve_cnt;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int val,int dir, int mv_cnt, int cnt, int curve_cnt) {
        this.x = x;
        this.y = y;
        this.val = val;
        this.dir = dir;
        this.mv_cnt = mv_cnt;
        this.cnt = cnt;
        this.curve_cnt = curve_cnt;
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
        int M = Integer.parseInt(br.readLine());

        Point answer = new Point(0,0);
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(N/2,N/2,1,0,1,0,0));
        int end = N*N;

        while(!q.isEmpty())
        {
            Point snail = q.poll();

            int dir = snail.dir;
            int val = snail.val;
            int cur_mv_cnt = snail.mv_cnt;
            int cur_cnt = snail.cnt;
            int cur_curve_cnt = snail.curve_cnt;

            if(val == M)
            {
                answer = new Point(snail.x,snail.y);
            }
            map[snail.x][snail.y] = val;
            if(val == end) break;

            if(cur_curve_cnt == 2)
            {
                cur_mv_cnt++;
                cur_curve_cnt = 0;
            }
            if(cur_mv_cnt == cur_cnt)
            {
                dir = (dir + 1) % 4;
                cur_curve_cnt++;
                cur_cnt = 0;
            }

            int mx = snail.x + dx[dir];
            int my = snail.y + dy[dir];
            q.add(new Point(mx,my,val+1,dir,cur_mv_cnt,cur_cnt+1,cur_curve_cnt));
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int [] i : map)
        {
            for(int j : i) bw.write(j+" ");
            bw.write("\n");
        }
        bw.write((answer.x+1)+" "+(answer.y+1));
        bw.flush();
        bw.close();
    }

    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
