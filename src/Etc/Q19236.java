package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Fish
{
    int x,y,dir;
    boolean isLive;

    public Fish(int x, int y, int dir,boolean isLive)
    {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.isLive = isLive;
    }


}
public class Q19236 {
    static int answer;
    static int [] dx = {0,-1,-1,0,1,1,1,0,-1}; // 0번인덱스 제외
    static int [] dy = {0,0,-1,-1,-1,0,1,1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int [][] map = new int[4][4];
        Fish [] fishes = new Fish[17];

        for(int i = 0; i < 4; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; ++j)
            {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                map[i][j] = num;
                fishes[num] = new Fish(i,j,dir,true);
            }
        }

        eat(0,0,fishes[map[0][0]].dir,0,map,fishes);
        System.out.print(answer);
    }

    static void eat(int x, int y,int dir,int eatCnt,int [][] map,Fish [] fishes)
    {
        eatCnt += map[x][y];
        fishes[map[x][y]].isLive = false;
        dir = fishes[map[x][y]].dir;
        map[x][y] = 0;

        if(eatCnt > answer) answer = eatCnt;
        moveFish(map,fishes,x,y);

        int mx = x,my = y;
        for(int idx = 0; idx < 3; ++idx)
        {
            mx += dx[dir];
            my += dy[dir];

            if(!isValid(mx,my)) break;
            if(map[mx][my] > 0)
            {
                int [][] copyMap = new int[4][4];
                for(int i = 0; i < 4; ++i)
                {
                    System.arraycopy(map[i],0,copyMap[i],0,4);
                }
                Fish [] copyFishes = new Fish[17];
                for(int i = 1; i < fishes.length; ++i)
                {
                    copyFishes[i] = new Fish(fishes[i].x,fishes[i].y,fishes[i].dir,fishes[i].isLive);
                }
                eat(mx,my,dir,eatCnt,copyMap,copyFishes);
            }
        }
    }
    static void moveFish(int [][] map, Fish [] fishes,int sharkX,int sharkY)
    {
        nextFish : for(int i = 1; i < fishes.length; ++i)
        {
            Fish cur = fishes[i];
            if(cur.isLive)
            {
                int cnt = 8;
                while(cnt-- > 0)
                {
                    if(cur.dir > 8) cur.dir = 1;
                    int mx = cur.x + dx[cur.dir];
                    int my = cur.y + dy[cur.dir];

                    if(!isValid(mx,my) || (sharkX == mx && sharkY == my))
                    {
                        cur.dir++;
                        continue;
                    }
                    if(map[mx][my] > 0)
                    {
                        swap(map,fishes,cur,fishes[map[mx][my]]);
                        continue nextFish;
                    }
                    else
                    {
                        map[mx][my] = map[cur.x][cur.y];
                        fishes[map[cur.x][cur.y]] = new Fish(mx,my,cur.dir,true);
                        map[cur.x][cur.y] = 0;
                        continue  nextFish;
                    }
                }
            }
        }
    }
    static void swap(int [][] map, Fish [] fishes, Fish o1, Fish o2)
    {
        int tmp = map[o1.x][o1.y];
        map[o1.x][o1.y] = map[o2.x][o2.y];
        map[o2.x][o2.y] = tmp;

        fishes[map[o2.x][o2.y]] = new Fish(o2.x,o2.y,o1.dir,true);
        fishes[map[o1.x][o1.y]] = new Fish(o1.x,o1.y,o2.dir,true);


    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < 4 && y < 4;
    }

}
