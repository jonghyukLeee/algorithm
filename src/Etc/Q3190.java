package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Snake
{
    int head_x,head_y;
    int tail_x,tail_y;
    int dir;

    public Snake(int head_x, int head_y,int tail_x, int tail_y,int dir)
    {
        this.head_x = head_x;
        this.head_y = head_y;
        this.tail_x = tail_x;
        this.tail_y = tail_y;
        this.dir = dir;
    }
}
class Command
{
    int time;
    char dir;

    public Command(int time, char dir)
    {
        this.time = time;
        this.dir = dir;
    }
}
public class Q3190 {
    static int [][] map;
    static Snake snake;
    static int res = 0;
    static int N;
    static Queue<Command> q;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        map = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i < K; ++i)
        {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = -1;
        }

        int L = Integer.parseInt(br.readLine());

        snake = new Snake(0,0,0,0,0);
        q = new LinkedList<>();
        for(int i = 0; i < L; ++i)
        {
            st = new StringTokenizer(br.readLine());
            q.add(new Command(Integer.parseInt(st.nextToken()),st.nextToken().charAt(0)));
        }

        loop : while(true)
        {
            Command cur;
            if(!q.isEmpty())
            {
                cur = q.poll(); // 3 D
            }
            else
            {
               cur = new Command(10001,'X');
            }
            while(cur.time > res)
            {
                res++;
                map[snake.head_x][snake.head_y] = snake.dir + 1;
                snake.head_x += dx[snake.dir];
                snake.head_y += dy[snake.dir];
                if(!isValid(snake.head_x,snake.head_y) || map[snake.head_x][snake.head_y] > 0) break loop;
                if(map[snake.head_x][snake.head_y] == -1) continue; //사과
                int tmp_dir = map[snake.tail_x][snake.tail_y];
                map[snake.tail_x][snake.tail_y] = 0;
                snake.tail_x += dx[tmp_dir-1];
                snake.tail_y += dy[tmp_dir-1];
            }
            if(cur.dir == 'D')
            {
                if(snake.dir == 3)
                {
                    snake.dir = 0;
                }
                else snake.dir++;
            }
            else
            {
                if(snake.dir == 0)
                {
                    snake.dir = 3;
                }
                else snake.dir--;
            }
            map[snake.head_x][snake.head_y] = snake.dir;
        }
        System.out.print(res);
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
