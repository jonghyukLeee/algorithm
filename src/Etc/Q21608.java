package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Seat
{
    int x,y;
    int blank;
    int cnt;

    public Seat(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public Seat(int x, int y,int blank)
    {
        this.x = x;
        this.y = y;
        this.blank = blank;
    }
    public Seat(int x, int y,int blank,int cnt)
    {
        this.x = x;
        this.y = y;
        this.blank = blank;
        this.cnt = cnt;
    }
}
public class Q21608 {
    static int N;
    static int [][] map;
    static int [][] answer;
    static boolean [][] visited;
    static Seat [] seats;
    static List<Integer>[] friends;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        answer = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for(int i = 1; i <= N; ++i)
        {
            for(int j = 1; j <= N; ++j)
            {
                if(i == 1 || j == 1 || i == N || j == N)
                {
                    map[i][j] = 3;
                }
                else map[i][j] = 4;
            }
        }

        map[1][1] = 2;
        map[1][N] = 2;
        map[N][1] = 2;
        map[N][N] = 2;

        int size = (N*N) + 1;
        friends = new List[size];
        for(int i = 0; i < size; ++i) friends[i] = new ArrayList<>();
        seats = new Seat[size];
        boolean [][] isFriend = new boolean[size][size];
        List<Integer> seq = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i < N*N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            seq.add(num);
            for(int j = 0; j < 4; ++j)
            {
                int friend = Integer.parseInt(st.nextToken());
                friends[num].add(friend);
                isFriend[num][friend] = true;
            }
        }

        for(int cur : seq) // 앉는 순서
        {
            PriorityQueue<Seat> tmp_pq = new PriorityQueue<>(new Comparator<Seat>()
            {
                @Override
                public int compare(Seat o1, Seat o2)
                {
                    if(o1.cnt == o2.cnt)
                    {
                        if(o1.blank == o2.blank)
                        {
                            if(o1.x == o2.x) return o1.y - o2.y;
                            return o1.x - o2.x;
                        }
                        return o2.blank - o1.blank;
                    }
                    return o2.cnt- o1.cnt;
                }
            });
            for(int f : friends[cur]) // 친한친구가 앉아있는지 탐색
            {
                if(seats[f] != null)
                {
                    for(int idx = 0; idx < 4; ++idx)
                    {
                        int cnt = 0;
                        int mx = seats[f].x + dx[idx];
                        int my = seats[f].y + dy[idx];

                        if(!isValid(mx,my) || visited[mx][my]) continue;
                        for(int i = 0; i < 4; ++i)
                        {
                            int x = mx + dx[i];
                            int y = my + dy[i];

                            if(!isValid(x,y) || !visited[x][y]) continue;
                            if(isFriend[cur][answer[x][y]]) cnt++;
                        }
                        tmp_pq.add(new Seat(mx,my,map[mx][my],cnt));
                    }
                }
            }
            Seat seat;
            if(!tmp_pq.isEmpty())
            {
                seat = tmp_pq.poll();
            }
            else
            {
                PriorityQueue<Seat> pq = new PriorityQueue<>(new Comparator<Seat>()
                {
                    @Override
                    public int compare(Seat o1, Seat o2)
                    {
                        if(o1.blank == o2.blank)
                        {
                            if(o1.x == o2.x) return o1.y - o2.y;
                            return o1.x - o2.x;
                        }
                        return o2.blank - o1.blank;
                    }
                });
                for(int i = 1; i <= N; ++i)
                {
                    for(int j = 1; j <= N; ++j)
                    {
                        if(!visited[i][j]) pq.add(new Seat(i,j,map[i][j]));
                    }
                }
                seat = pq.poll();
            }
            seats[cur] = new Seat(seat.x,seat.y);
            answer[seat.x][seat.y] = cur;
            visited[seat.x][seat.y] = true;

            for(int idx = 0; idx < 4; ++idx)
            {
                int mx = seat.x + dx[idx];
                int my = seat.y + dy[idx];

                if(!isValid(mx,my) || visited[mx][my]) continue;
                map[mx][my]--;
            }
        }

        int [] score = {0,1,10,100,1000};
        int total = 0;
        for(int i = 1; i <= N; ++i)
        {
            for(int j = 1; j <= N; ++j)
            {
                int cnt = 0;
                for(int idx = 0; idx < 4; ++idx)
                {
                    int mx = i + dx[idx];
                    int my = j + dy[idx];

                    if(isValid(mx,my))
                    {
                        if(isFriend[answer[i][j]][answer[mx][my]]) cnt++;
                    }
                }
                total += score[cnt];
            }
        }
        System.out.print(total);
    }
    static boolean isValid(int x, int y)
    {
        return x > 0 && y > 0 && x <= N && y <= N;
    }
}
