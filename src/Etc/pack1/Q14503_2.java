package Etc.pack1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Robot
{
    int x,y,dir;

    public Robot(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}
public class Q14503_2 {
    static int N,M;
    static Robot robot;
    static int [][] map;
    static boolean [][] cleaned;
    static int answer = 1;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cleaned = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        robot = new Robot(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        run();
        System.out.println(answer);
    }
    static void run()
    {
        Queue<Robot> q = new LinkedList<>();
        q.add(robot);
        cleaned[robot.x][robot.y] = true;
        while(!q.isEmpty())
        {
            Robot cur = q.poll();
            int next_dir = find(cur);
            int mx = cur.x;
            int my = cur.y;
            if(next_dir < 0) // 청소할 곳이 없을경우 후진 , 방향은 유지
            {
                next_dir = (cur.dir + 2) % 4;
                mx += dx[next_dir];
                my += dy[next_dir];
                if(!isValid(mx,my) || map[mx][my] > 0) break; // 종료조건
                q.add(new Robot(mx,my,cur.dir));
            }
            else
            {
                mx += dx[next_dir];
                my += dy[next_dir];

                cleaned[mx][my] = true;
                answer++;
                q.add(new Robot(mx,my,next_dir));
            }
        }
    }
    static int find(Robot cur)
    {
        int next_dir = cur.dir;
        for(int i = 0; i < 4; ++i)
        {
            next_dir = (next_dir + 3) % 4;
            int mx = cur.x + dx[next_dir];
            int my = cur.y + dy[next_dir];

            if(!isValid(mx,my) || cleaned[mx][my] || map[mx][my] > 0) continue;
            return next_dir;
        }
        return -1;
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
