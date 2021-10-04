package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Cam
{
    int x,y;

    public Cam(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class Q15683 {
    static int N,M,zero_cnt;
    static int [][] map;
    static List<Cam> tv_loc;
    static boolean [] tv;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        tv_loc = new ArrayList<>();
        tv = new boolean[6];


        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0 && map[i][j] < 6)
                {
                    tv_loc.add(new Cam(i,j));
                    if(!tv[map[i][j]]) tv[map[i][j]] = true;
                }
                else if(map[i][j] == 0) zero_cnt++;
            }
        }
//        0의 총 갯수를 카운트해두고,
//        함수 내에서 각 경우의 수 마다 줄여가는 0의 갯수도 카운트.
//        해당 경우에서 줄여낸 0의 갯수를 총 카운트에서 빼주면, 사각지대의 넓이를 구할수있음.
    }
    static void scan()
    {

    }
}
