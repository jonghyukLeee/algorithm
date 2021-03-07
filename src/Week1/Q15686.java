package Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point3
{
    int x,y;

    public Point3(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class Q15686 {
    static int arr[][];
    static ArrayList<Point3> cPoint;
    static ArrayList<Point3> hPoint;
    static boolean isVisit [];
    static int res;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        cPoint = new ArrayList<Point3>();
        hPoint = new ArrayList<Point3>();
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        res = Integer.MAX_VALUE;
        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; ++j)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1)
                {
                    hPoint.add(new Point3(i,j));
                }
                if(arr[i][j] == 2)
                {
                    cPoint.add(new Point3(i,j));
                }
            }
        }
        isVisit = new boolean[cPoint.size()];
        dfs(0,0);
        System.out.print(res);
    }
    static void dfs(int n, int cnt)
    {
        if(cnt == m)
        {
            int dis = 0;
            for(int i =0; i < hPoint.size(); ++i)
            {
                int min = Integer.MAX_VALUE;
                for(int j = 0; j < cPoint.size(); ++j)
                {
                    if(isVisit[j])
                    {
                        int tmp = Math.abs(hPoint.get(i).x-cPoint.get(j).x)+Math.abs(hPoint.get(i).y-cPoint.get(j).y);
                        min = Math.min(tmp,min);
                    }
                }
                dis+=min;
            }
            res = Math.min(dis,res);
            return;
        }
        for(int i = n; i < cPoint.size();++i)
        {
            isVisit[i] = true;
            dfs(i+1,cnt+1);
            isVisit[i] = false;
        }
    }
}

