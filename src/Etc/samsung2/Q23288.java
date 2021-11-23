package Etc.samsung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Tile
{
    boolean visited;
    int val,point;

    public Tile(int val)
    {
        this.val = val;
    }
    public void setPoint(int point)
    {
        this.point = point;
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
    static int tmp_val;
    static Dice dice;
    static boolean [][] visited;
    static Tile [][] map;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1}; // 상 우 하 좌

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new Tile[N+1][M+1];

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
                map[i][j] = new Tile(Integer.parseInt(st.nextToken()));
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

        if(!map[dice.x][dice.y].visited)
        {
            visited = new boolean[N+1][M+1];
            visited[dice.x][dice.y] = true;
            tmp_val = map[dice.x][dice.y].val;
            getScore(dice.x,dice.y,tmp_val,1);
        }
        answer += map[dice.x][dice.y].point;

        int bot = dice.bot;
        int tile = map[dice.x][dice.y].val;
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
    static void getScore(int x, int y,int val, int cnt)
    {
        if(tmp_val < val * cnt) tmp_val = val * cnt;

        for(int idx = 0; idx < 4; ++idx)
        {
            int mx = x + dx[idx];
            int my = y + dy[idx];

            if(isValid(mx,my) && !visited[mx][my] && map[mx][my].val == val)
            {
                visited[mx][my] = true;
                getScore(mx,my,val,cnt+1);
                visited[mx][my] = false;
            }
        }

        map[x][y].setPoint(tmp_val);
        map[x][y].visited = true;
    }
    static boolean isValid(int x, int y)
    {
        return x > 0 && y > 0 && x <= N && y <= M;
    }
}
