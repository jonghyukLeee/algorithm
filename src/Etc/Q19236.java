package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
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
    static int [][] map;
    static Fish [] fishes;
    static int [] dx = {0,-1,-1,0,1,1,1,0,-1}; // 0번인덱스 제외
    static int [] dy = {0,0,-1,-1,-1,0,1,1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[4][4];
        fishes = new Fish[17];

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

        int tmpDir = fishes[map[0][0]].dir;
        eat(0,0,tmpDir,0);
        System.out.print(answer);
    }

    static void eat(int x, int y,int dir,int eatCnt)
    {
        if(eatCnt > answer) answer = eatCnt;
        int [][] copyMap = new int[4][4];
        for(int i = 0; i < 4; ++i) System.arraycopy(map[i],0,copyMap[i],0,4);
        Fish [] copyFishes = new Fish[17];
        for(int i = 1; i < fishes.length; ++i) copyFishes[i] = new Fish(fishes[i].x,fishes[i].y,fishes[i].dir,fishes[i].isLive);

        eatCnt += copyMap[x][y];
        copyFishes[copyMap[x][y]].isLive = false;
        copyMap[x][y] = 0;

        moveFish(copyMap,copyFishes,x,y);
        for(int i = 0; i < 3; ++i)
        {
            int mx = x + dx[dir];
            int my = y + dy[dir];

            if(!isValid(mx,my)) break;
            eat(mx,my,dir,eatCnt);
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
                        fishes[map[cur.x][cur.y]] = new Fish(mx,my,cur.dir,cur.isLive);
                        map[cur.x][cur.y] = 0;
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

        fishes[tmp] = new Fish(o2.x,o2.y,o2.dir,o2.isLive);
        fishes[map[o2.x][o2.y]] = new Fish(o1.x,o1.y,o1.dir,o1.isLive);

    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < 4 && y < 4;
    }

}
