package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Robot
{
    int x,y,direc;

    public Robot(int x, int y, int direc)
    {
        this.x = x;
        this.y = y;
        this.direc = direc;
    }
}
public class Q14503 {
    static boolean [][] map;
    static Queue<Robot> q;
    static int answer = 1;
    static boolean [] isVis;
    static boolean [][] isCleaned;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];
        isCleaned = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        int rx = Integer.parseInt(st.nextToken());
        int ry = Integer.parseInt(st.nextToken());
        int rdir = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();
        q.add(new Robot(rx,ry,rdir));
        isCleaned[rx][ry] = true;

        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; ++j)
            {
                if(st.nextToken().equals("1"))
                {
                    map[i][j] = true;
                }
            }
        }
        run();
        System.out.println(answer);
    }
    static void run()
    {
        while(!q.isEmpty())
        {
            Robot poll = q.poll();
            isVis = new boolean[4];
            search(poll);
            if(q.isEmpty())
            {
                int idx = poll.direc + 2 >= isVis.length ? poll.direc-2 : poll.direc+2;
                int mx = poll.x + dx[idx], my = poll.y + dy[idx];
                if(!map[mx][my]) q.add(new Robot(mx,my,poll.direc));
            }
        }
    }
    static void search(Robot robot)
    {
        int direc = robot.direc-1;
        if(direc == -1) direc = 3;
        if(isVis[direc]) return;
        isVis[direc] = true;
        int mx = robot.x + dx[direc], my = robot.y + dy[direc];
        if(!map[mx][my] && !isCleaned[mx][my])
        {
            q.add(new Robot(mx,my,direc));
            answer++;
            isCleaned[mx][my] = true;
            return;
        }
        search(new Robot(robot.x,robot.y,direc));
    }
}
