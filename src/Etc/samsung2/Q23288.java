package Etc.samsung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
class Dice
{
    int x,y,dir;
    int top,bot,left,right,front,back;

    public Dice(int x, int y, int dir)
    {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public void setBot(int bot) {
        this.bot = bot;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public void setBack(int back) {
        this.back = back;
    }
}
public class Q23288 {
    static int N,M,K;
    static int answer;
    static Dice dice;
    static int [] points;
    static int [][] group;
    static int [][] map;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1}; // 상 우 하 좌

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        group = new int[N+1][M+1];
        points = new int[401];

        dice = new Dice(1,1,1);
        dice.setTop(1);
        dice.setFront(2);
        dice.setRight(3);
        dice.setLeft(4);
        dice.setBack(5);
        dice.setBot(6);

        for(int i = 1; i <= N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int group_num = 1;
        for(int i = 1; i <= N; ++i)
        {
            for(int j = 1; j <= M; ++j)
            {
                if(group[i][j] < 1)
                {
                    bfs(i,j,map[i][j],group_num++);
                }
            }
        }

        while(K-- > 0) move();
        System.out.print(answer);
    }
    static void move()
    {
        int mx = dice.x + dx[dice.dir];
        int my = dice.y + dy[dice.dir];

        if(!isValid(mx,my))
        {
            dice.dir = (dice.dir + 2) % 4;
            mx = dice.x + dx[dice.dir];
            my = dice.y + dy[dice.dir];
        }

        roll(dice.dir);
        dice.x = mx;
        dice.y = my;

        int cur_group = group[dice.x][dice.y];
        answer += points[cur_group];

        int bot = dice.bot;
        int tile = map[dice.x][dice.y];
        if(bot > tile) dice.dir = (dice.dir + 1) % 4;
        else if(bot < tile) dice.dir = (dice.dir + 3) % 4;

    }
    static void roll(int dir)
    {
        int tmp_top = dice.top;
        int tmp_bot = dice.bot;
        int tmp_left = dice.left;
        int tmp_right = dice.right;
        int tmp_front = dice.front;
        int tmp_back = dice.back;
        if(dir == 0)
        {
            dice.setTop(tmp_back);
            dice.setBot(tmp_front);
            dice.setFront(tmp_top);
            dice.setBack(tmp_bot);
        }
        else if(dir == 1)
        {
            dice.setTop(tmp_left);
            dice.setBot(tmp_right);
            dice.setLeft(tmp_bot);
            dice.setRight(tmp_top);
        }
        else if(dir == 2)
        {
            dice.setTop(tmp_front);
            dice.setBot(tmp_back);
            dice.setFront(tmp_bot);
            dice.setBack(tmp_top);
        }
        else
        {
            dice.setTop(tmp_right);
            dice.setBot(tmp_left);
            dice.setLeft(tmp_top);
            dice.setRight(tmp_bot);
        }
    }
    static void bfs(int i, int j,int val,int group_num)
    {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i,j));
        int cnt = 0;
        while(!q.isEmpty())
        {
            Point cur = q.poll();
            if(group[cur.x][cur.y] > 0) continue;
            cnt++;
            group[cur.x][cur.y] = group_num;

            for(int idx = 0; idx < 4; ++idx)
            {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if(!isValid(mx,my) || group[mx][my] > 0 || val != map[mx][my]) continue;
                q.add(new Point(mx,my));
            }
        }
        points[group_num] = cnt * val;
    }
    static boolean isValid(int x, int y)
    {
        return x > 0 && y > 0 && x <= N && y <= M;
    }
}
