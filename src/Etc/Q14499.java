package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Dice
{
    int x,y,top,bottom,left,right,front,back;

    public Dice(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
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

    public void setTop(int top) {
        this.top = top;
    }
}
public class Q14499 {
    static int n,m;
    static int [][] map;
    static Dice dice;
    static int [] dx = {0,0,-1,1}; // 동 서 북 남
    static int [] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        dice = new Dice(startX,startY);

        map = new int[n][m];
        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine()); // 이동명령

        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens())
        {
            int next = Integer.parseInt(st.nextToken())-1;

            int curX = dice.x, curY = dice.y; // 현위치
            int mx = curX + dx[next], my = curY + dy[next];

            if(!isValid(mx,my)) continue;
            dice.x = mx;
            dice.y = my;
            roll(next);

            if(map[mx][my] == 0)
            {
                map[mx][my] = dice.bottom;
            }
            else
            {
                dice.setBottom(map[mx][my]);
                map[mx][my] = 0;
            }
            sb.append(dice.top).append("\n");
        }
        System.out.print(sb.toString());
    }
    static void roll(int direc)
    {
        switch(direc)
        {
            case 0:
            {
                int tmpTop = dice.top,tmpBottom = dice.bottom, tmpLeft = dice.left, tmpRight = dice.right;
                dice.setTop(tmpRight);
                dice.setLeft(tmpTop);
                dice.setRight(tmpBottom);
                dice.setBottom(tmpLeft);
                break;
            }
            case 1:
            {
                int tmpTop = dice.top,tmpBottom = dice.bottom, tmpLeft = dice.left, tmpRight = dice.right;
                dice.setTop(tmpLeft);
                dice.setLeft(tmpBottom);
                dice.setRight(tmpTop);
                dice.setBottom(tmpRight);
                break;
            }
            case 2:
            {
                int tmpTop = dice.top,tmpBottom = dice.bottom,tmpFront = dice.front, tmpBack = dice.back;
                dice.setTop(tmpFront);
                dice.setFront(tmpBottom);
                dice.setBack(tmpTop);
                dice.setBottom(tmpBack);
                break;
            }
            case 3:
            {
                int tmpTop = dice.top,tmpBottom = dice.bottom,tmpFront = dice.front, tmpBack = dice.back;
                dice.setTop(tmpBack);
                dice.setFront(tmpTop);
                dice.setBack(tmpBottom);
                dice.setBottom(tmpFront);
                break;
            }
        }
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
