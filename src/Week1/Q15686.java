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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        cPoint = new ArrayList<Point3>();
        hPoint = new ArrayList<Point3>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
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
    }
}
