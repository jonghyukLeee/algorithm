package Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point2
{
    int x,y,z,day;
    public Point2(int z, int y, int x, int day)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.day = day;
    }
}
public class Q7569 {
    static int box [][][];
    static int move_x [] = {0,0,0,0,1,-1};
    static int move_y [] = {0,0,1,-1,0,0};
    static int move_z [] = {1,-1,0,0,0,0};
    static int min_day;
    static ArrayList<Point2> arrayList;
    static boolean isVisited [][][];
    static void bfs()
    {
        Queue<Point2> q = new LinkedList<>();
        for(Point2 i : arrayList)
        {
            int x = i.x;
            int y = i.y;
            int z = i.z;
            //System.out.printf("(bfs): add to Q(%d,%d,%d)\n",x,y,z);
            q.add(new Point2(z,y,x,0));
        }
        while(!q.isEmpty())
        {
            Point2 p = q.poll();
            int x = p.x;
            int y = p.y;
            int z = p.z;
            int d = p.day;
            System.out.printf("(queue): poll and move(%d,%d,%d), day = %d\n",x,y,z,d);
            if(min_day < d)
            {
                System.out.printf("min = %d\n",min_day);
                min_day = d;
            }

            for(int i = 0; i < 6; ++i)
            {
                int dx = x+move_z[i];
                int dy = y+move_y[i];
                int dz = z+move_x[i];
                System.out.printf("(%d,%d,%d) + (%d,%d,%d)->",x,y,z,move_z[i],move_y[i],move_x[i]);
                if(dx<0 || dy<0 || dz<0 || dx >= box.length || dy>=box[0].length || dz>= box[0][0].length)
                {
                    System.out.println("fail");
                    continue;
                }
                if(box[dx][dy][dz]>=0 && !isVisited[dx][dy][dz])
                {
                    System.out.println("success");
                    box[dx][dy][dz] = 1;
                    //System.out.printf("(%d,%d,%d) = 1\n",dx,dy,dz);
                    q.add(new Point2(dz,dy,dx,d+1));
                }
                System.out.printf("(%d,%d,%d) visited\n",dx,dy,dz);
            }
        }


    }
    static int checkArr(int [][][] arr)
    {
        for(int i = 0; i < arr.length; ++i)
        {
            for(int j = 0; j < arr[0].length; ++j)
            {
                for(int k = 0; k < arr[0][0].length; ++k)
                {
                    if(arr[i][j][k]==0) return -1;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arrayList = new ArrayList<>();
        min_day = 0;
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());
        box = new int[z][y][x];
        isVisited = new boolean[z][y][x];
        for(int i = 0; i < z; ++i)
        {
            for(int j = 0; j < y; ++j)
            {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < x; ++k)
                {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    //System.out.printf("(%d,%d,%d) = %d\n",i,j,k,box[i][j][k]);
                    if(box[i][j][k] == 1)
                    {
                        arrayList.add(new Point2(k,j,i,0));
                    }
                }
            }
        }
        System.out.println("끝");
        bfs();
        System.out.println(checkArr(box));
    }
}
