package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Piece
{
    int x,y,dir;

    public Piece(int x, int y, int dir)
    {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}
public class Q17837 {
    static int N,K;
    static List<Integer>[][] map;
    static Piece [] piece;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {1,-1,0,0}; //우 좌 상 하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new List[N][N];
        piece = new Piece[K+1];

        for(int i = 0; i < N; ++i) // 0흰 1빨 2파
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j)
            {
                map[i][j] = new ArrayList<>();
                map[i][j].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 1; i <= K; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken())-1;
            piece[i] = new Piece(x,y,dir);
            map[x][y].add(i);
        }

        int t = 0;
        boolean flag = false;
        loop : while(t++ < 1000)
        {
            for(int i = 1; i <= K; ++i)
            {
                System.out.printf("move %d at (%d,%d) dir = %d\n",i,piece[i].x,piece[i].y,piece[i].dir);
                flag = next(piece[i],i);
                if(flag) break loop;
                for(int j = 0; j < N; ++j)
                {
                    for(int k = 0; k < N; ++k)
                    {
                        System.out.printf("(%d,%d) ",j,k);
                        for(int l : map[j][k])
                        {
                            System.out.print(l+" ");
                        }
                        System.out.println();
                    }
                }
            }
        }
        int answer = t == 1000 ? -1 : t;
        System.out.print(answer);
    }
    static boolean next(Piece p,int n)
    {
        int cur_x = p.x;
        int cur_y = p.y;
        int level = 0;
        int size = map[cur_x][cur_y].size();
        for(int i = 1; i < size; ++i)
        {
            if(map[cur_x][cur_y].get(i) == n)
            {
                level = i;
                break;
            }
        }
        int mx = cur_x + dx[p.dir];
        int my = cur_y + dy[p.dir];
        int nextBlock = 2;

        if(isValid(mx,my)) nextBlock = map[mx][my].get(0);

        if(nextBlock == 2) // 범위벗어났거나 파란블록
        {
            int dir;
            if(p.dir == 0) dir = 1;
            else if(p.dir == 1) dir = 0;
            else if(p.dir == 2) dir = 3;
            else dir = 2;

            mx = cur_x + dx[dir];
            my = cur_y + dy[dir];

            if(!isValid(mx,my) || map[mx][my].get(0) == 2) p.dir = dir;
            else move(map[mx][my].get(0),level,size,cur_x,cur_y,mx,my);
        }
        else move(nextBlock,level,size,cur_x,cur_y,mx,my);
        return map[mx][my].size() > 4; // 방향전환시 mx,my값이 범위를 벗어난 값일 경우가 있어서 사이즈 체크하는 구간을 변경해야함. move함수가 좋을듯
    }
    static void move(int color,int start, int end, int x, int y, int mx,int my)
    {
        List<Integer> tmp_list = map[x][y].subList(start,end);
        if(color == 0) // 흰색
        {
            for(int i : tmp_list)
            {
                map[mx][my].add(i);
                piece[i].x = mx;
                piece[i].y = my;
            }
        }
        else // 빨강
        {
            for(int i = tmp_list.size()-1; i >= 0; --i)
            {
                int num = tmp_list.get(i);
                map[mx][my].add(num);
                piece[num].x = mx;
                piece[num].y = my;
            }
        }
        map[x][y].subList(start,end).clear();
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
