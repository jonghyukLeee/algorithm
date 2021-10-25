package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q12100 {
    static int max_val = Integer.MIN_VALUE;
    static int N;
    static int [][] map;
    static boolean [][] visited;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > max_val)
                {
                    max_val = map[i][j];
                }
            }
        }
        comb(new ArrayList<>());
        System.out.print(max_val);
    }
    static void comb(List<Integer> al)
    {
        if(al.size() == 5)
        {
            int [][] copy = new int[N][N];
            for(int i = 0; i < N; ++i) System.arraycopy(map[i],0,copy[i],0,N);

            play(al,copy);
            return;
        }

        for(int i = 0; i < 4; ++i)
        {
            List<Integer> tmp = new ArrayList<>(al);
            tmp.add(i);
            comb(tmp);
        }
    }
    static void play(List<Integer> al, int [][] copy)
    {
        int tmp_val = Integer.MIN_VALUE;

        for(int dir : al)
        {
            visited = new boolean[N][N];
            switch(dir)
            {
                // 상
                case 0:
                {
                    for(int j = 0; j < N; ++j)
                    {
                        next : for(int i = 1; i < N; ++i)
                        {
                            if(copy[i][j] > 0)
                            {
                                int num = copy[i][j];
                                int mx = i + dx[dir];
                                int my = j + dy[dir];
                                while(true)
                                {
                                    if(!isValid(mx,my) || visited[mx][my]) break;
                                    if(copy[mx][my] > 0)
                                    {
                                        if(copy[mx][my] == num)
                                        {
                                            copy[mx][my] = num * 2;
                                            if(copy[mx][my] > tmp_val) tmp_val = copy[mx][my];
                                            copy[i][j] = 0;
                                            visited[mx][my] = true;
                                            continue next;
                                        }
                                        else break;
                                    }
                                    mx += dx[dir];
                                    my += dy[dir];
                                }
                                // 1칸 아래로
                                mx += dx[1];
                                my += dy[1];
                                if(mx != i)
                                {
                                    copy[mx][my] = num;
                                    copy[i][j] = 0;
                                }
                            }
                        }
                    }
                    break;
                }
                // 하
                case 1:
                {
                    for(int j = 0; j < N; ++j)
                    {
                        next : for(int i = N-2; i >= 0; --i)
                        {
                            if(copy[i][j] > 0)
                            {
                                int num = copy[i][j];
                                int mx = i + dx[dir];
                                int my = j + dy[dir];
                                while(true)
                                {
                                    if(!isValid(mx,my) || visited[mx][my]) break;
                                    if(copy[mx][my] > 0)
                                    {
                                        if(copy[mx][my] == num)
                                        {
                                            copy[mx][my] = num * 2;
                                            if(copy[mx][my] > tmp_val) tmp_val = copy[mx][my];
                                            copy[i][j] = 0;
                                            visited[mx][my] = true;
                                            continue next;
                                        }
                                        else break;
                                    }
                                    mx += dx[dir];
                                    my += dy[dir];
                                }
                                // 1칸 위로
                                mx += dx[0];
                                my += dy[0];
                                if(mx != i)
                                {
                                    copy[mx][my] = num;
                                    copy[i][j] = 0;
                                }
                            }
                        }
                    }
                    break;
                }
                // 좌
                case 2:
                {
                    for(int i = 0; i < N; ++i)
                    {
                        next : for(int j = 1; j < N; ++j)
                        {
                            if(copy[i][j] > 0)
                            {
                                int num = copy[i][j];
                                int mx = i + dx[dir];
                                int my = j + dy[dir];
                                while(true)
                                {
                                    if(!isValid(mx,my) || visited[mx][my]) break;
                                    if(copy[mx][my] > 0)
                                    {
                                        if(copy[mx][my] == num)
                                        {
                                            copy[mx][my] = num * 2;
                                            if(copy[mx][my] > tmp_val) tmp_val = copy[mx][my];
                                            copy[i][j] = 0;
                                            visited[mx][my] = true;
                                            continue next;
                                        }
                                        else break;
                                    }
                                    mx += dx[dir];
                                    my += dy[dir];
                                }
                                // 1칸 우측
                                mx += dx[3];
                                my += dy[3];
                                if(my != j)
                                {
                                    copy[mx][my] = num;
                                    copy[i][j] = 0;
                                }
                            }
                        }
                    }
                    break;
                }
                // 우
                case 3:
                {
                    for(int i = 0; i < N; ++i)
                    {
                        next : for(int j = N-2; j >= 0; --j)
                        {
                            if(copy[i][j] > 0)
                            {
                                int num = copy[i][j];
                                int mx = i + dx[dir];
                                int my = j + dy[dir];
                                while(true)
                                {
                                    if(!isValid(mx,my) || visited[mx][my]) break;
                                    if(copy[mx][my] > 0)
                                    {
                                        if(copy[mx][my] == num)
                                        {
                                            copy[mx][my] = num * 2;
                                            if(copy[mx][my] > tmp_val) tmp_val = copy[mx][my];
                                            copy[i][j] = 0;
                                            visited[mx][my] = true;
                                            continue next;
                                        }
                                        else break;
                                    }
                                    mx += dx[dir];
                                    my += dy[dir];
                                }
                                // 1칸 왼쪽
                                mx += dx[2];
                                my += dy[2];
                                if(my != j)
                                {
                                    copy[mx][my] = num;
                                    copy[i][j] = 0;
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }
        max_val = Math.max(tmp_val,max_val);
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
