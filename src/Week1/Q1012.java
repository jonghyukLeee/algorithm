package Week1;

import java.io.*;
import java.util.StringTokenizer;

public class Q1012 {
    /**
     * 차세대 영농인 한나는 강원도 고랭지에서 유기농 배추를 재배하기로 하였다. 농약을 쓰지 않고 배추를 재배하려면 배추를 해충으로부터
     * 보호하는 것이 중요하기 때문에, 한나는 해충 방지에 효과적인 배추흰지렁이를 구입하기로 결심한다.
     * 이 지렁이는 배추근처에 서식하며 해충을 잡아 먹음으로써 배추를 보호한다.
     * 특히, 어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있어,
     * 그 배추들 역시 해충으로부터 보호받을 수 있다.
     *
     * (한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있다고 간주한다)
     *
     * 한나가 배추를 재배하는 땅은 고르지 못해서 배추를 군데군데 심어놓았다.
     * 배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 되므로 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면
     * 총 몇 마리의 지렁이가 필요한지 알 수 있다.
     * 필요한 최소의 배추흰지렁이 마리 수를 출력한다.
     */
    static int [] move_x = {-1,1,0,0};
    static int [] move_y = {0,0,-1,1};
    static boolean [][] isVisited;
    static void dfs(int [][] arr, int x, int y)
    {
        for(int i = 0; i < 4; ++i)
        {
            int mvd_x = x + move_x[i];
            int mvd_y = y + move_y[i];
            if(mvd_x < 0 || mvd_y < 0 || mvd_x >= arr.length || mvd_y >= arr[0].length) continue;
            if(arr[mvd_x][mvd_y] == 1 && !isVisited[mvd_x][mvd_y])
            {
                isVisited[mvd_x][mvd_y] = true;
                dfs(arr,mvd_x,mvd_y);
            }
            else isVisited[mvd_x][mvd_y] = true;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int arr[][];
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int cnt = 0;
            arr = new int[y][x];
            for(int i = 0; i < n; ++i)
            {
                st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            isVisited  = new boolean[y][x];
            for(int i = 0; i < arr.length; ++i)
            {
                for(int j = 0; j < arr[0].length; ++j)
                {
                    if(!isVisited[i][j] && arr[i][j] == 1)
                    {
                        isVisited[i][j] = true;
                        dfs(arr,i,j);
                        cnt++;
                    }
                }
            }
            bw.write(cnt+"\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
