package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point
{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q20165 {
    static int N,M,R;
    static int [][] map;
    static char [][] domino;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        domino = new char[N+1][M+1];

        // 도미노 초기화
        for(int i = 1; i <= N; ++i)
        {
            Arrays.fill(domino[i],'S');
        }

        for(int i = 1 ; i <= N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(R-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int atkX = Integer.parseInt(st.nextToken());
            int atkY = Integer.parseInt(st.nextToken());
            int dir = getDir(st.nextToken().charAt(0));

            st = new StringTokenizer(br.readLine());
            int defX = Integer.parseInt(st.nextToken());
            int defY = Integer.parseInt(st.nextToken());

            // 서있는 도미노를 선택했다면 공격.
            if(domino[atkX][atkY] == 'S')
            {
                domino[atkX][atkY] = 'F';
                answer += attack(atkX,atkY,dir);
            }

            // 수비
            domino[defX][defY] = 'S';
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        for(int i = 1; i <= N; ++i)
        {
            for(int j = 1; j <= M; ++j)
            {
                sb.append(domino[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static int attack(int x, int y, int dir)
    {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        int res = 1;
        while(!q.isEmpty())
        {
            Point cur = q.poll();
            //도미노의 높이
           int curH = map[cur.x][cur.y];

           //높이 -1개 만큼 쓰러짐
            int mx = cur.x;
            int my = cur.y;
           for(int t = 1; t < curH; ++t)
           {
               mx += dx[dir];
               my += dy[dir];

               //범위를 벗어나면, 더이상 진행할필요 x
               if(!isValid(mx,my)) break;
               //이미 넘어져있다면 다음반복 , 높이에 따라 더 진행할 수도 있기때문
               if(domino[mx][my] == 'F') continue;
               domino[mx][my] = 'F';
               res++;
               q.add(new Point(mx,my));
           }
        }
        return res;
    }
    static int getDir(char c)
    {
        if(c == 'E') return 3;
        else if(c == 'W') return 2;
        else if(c == 'S') return 1;
        else return 0;
    }

    static boolean isValid(int x, int y)
    {
        return x > 0 && y > 0 && x <= N && y <= M;
    }

}
