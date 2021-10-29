package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Shark
{
    int x,y,dir,mv_cnt,size;

    public Shark(int x, int y, int mv_cnt, int dir, int size)
    {
        this.x = x;
        this.y = y;
        this.mv_cnt = mv_cnt;
        this.dir = dir;
        this.size = size;
    }

}
public class Q17143 {
    static int answer;
    static PriorityQueue<Shark> sharks;
    static List<Shark> tmp_list;
    static int dead_x,dead_y;
    static int [][] map;
    static int R,C,M;
    static int [] dx = {0,-1,1,0,0}; // 상 하 우 좌
    static int [] dy = {0,0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[R+1][C+1];
        sharks = new PriorityQueue<>(new Comparator<Shark>() {
            @Override
            public int compare(Shark o1, Shark o2) {
                return o2.size - o1.size;
            }
        });


        for(int i = 0; i < M; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            map[r][c] = z;
            sharks.add(new Shark(r,c,s,d,z));
        }
        int fisherman = 0;
        while(fisherman++ < C)
        {
            dead_x = 0;
            dead_y = 0;
            for(int i = 1; i <= R; ++i) // 낚시
            {
                if(map[i][fisherman] > 0)
                {
                    answer += map[i][fisherman];
                    map[i][fisherman] = 0;
                    dead_x = i;
                    dead_y = fisherman;
                    break;
                }
            }
            map = new int[R+1][C+1];
            tmp_list = new ArrayList<>();
            move();
            sharks.clear();
            sharks.addAll(tmp_list);
        }
        System.out.print(answer);
    }
    static void move()
    {
        while(!sharks.isEmpty())
        {
            Shark cur = sharks.poll();
            if(cur.x == dead_x && cur.y == dead_y) continue; // 죽은 상어의 좌표일경우

            int mx = cur.x;
            int my = cur.y;
            int dir = cur.dir;
            for(int i = 0; i < cur.mv_cnt; ++i)
            {
                mx += dx[dir];
                my += dy[dir];

                if(!isValid(mx,my))
                {
                    dir = turn(dir);
                    i -= 2;
                }
            }
            if(map[mx][my] > 0) continue;
            map[mx][my] = cur.size;
            tmp_list.add(new Shark(mx,my,cur.mv_cnt,dir,cur.size));
        }

    }
    static int turn(int dir)
    {
        if(dir == 1) return 2;
        else if(dir == 2) return 1;
        else if(dir == 3) return 4;
        else if(dir == 4) return 3;
        else return 0; //default
    }
    static boolean isValid(int x, int y)
    {
        return x > 0 && y > 0 && x <= R && y <= C;
    }
}
