package First.Week1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** 백준 7562번 > 나이트의 이동
 * 체스판 위에 한 나이트가 놓여져 있다.
 * 나이트가 이동하려고 하는 칸이 주어진다. 나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?
 */
class Point
{
    int x,y,cnt;

    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.cnt = 0;
    }
    Point(int x, int y, int cnt)
    {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
public class Q7562 {
    static int bfs(int[][] arr,Point[] p)
    {
        Queue<Point> q = new LinkedList<>();
        q.add(p[0]);
        boolean[][] isVisited = new boolean[arr.length][arr.length];
        isVisited[p[0].x][p[0].y] = true;

        while(!q.isEmpty())
        {
            Point cp = q.poll();
            if(cp.x == p[1].x && cp.y == p[1].y)
            {
                return cp.cnt;
            }
            else
            {
                for(int i = 0; i < 8; ++i)
                {
                    int x = cp.x + move_x[i];
                    int y = cp.y + move_y[i];
                    if(x < 0 || y < 0 || x >= arr.length || y >= arr.length)
                    {
                        continue;
                    }
                    if(!isVisited[x][y])
                    {
                        isVisited[x][y] = true;
                        q.add(new Point(x,y,cp.cnt+1));
                    }
                }
            }
        } //end of while
        return 0;
    }
    static int[] move_x = {-2,-2,-1,-1,1,1,2,2};
    static int[] move_y = {-1,1,-2,2,-2,2,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Point[] p = new Point[2];
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0)
        {
            int input_size = Integer.parseInt(br.readLine());
            int arr[][] = new int[input_size][input_size];

            for(int i = 0 ; i < 2; ++i)
            {
                st = new StringTokenizer(br.readLine());

                int input_x = Integer.parseInt(st.nextToken());
                int input_y = Integer.parseInt(st.nextToken());

                p[i] = new Point(input_x,input_y);
            }
            sb.append(bfs(arr,p)+"\n");

        } //end of while
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
