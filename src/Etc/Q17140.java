package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Number
{
    int n,cnt;

    public Number(int n, int cnt)
    {
        this.n = n;
        this.cnt = cnt;
    }
}
public class Q17140 {
    static int R,C,K;
    static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken())-1;
        C = Integer.parseInt(st.nextToken())-1;
        K = Integer.parseInt(st.nextToken());

        map = new int[3][3];
        for(int i = 0; i < 3; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int r_size = 3;
        int c_size = 3;
        int t = 0;
        boolean flag = false;
        while(t++ <= 100)
        {
            if((R < r_size) && (C < c_size))
            {
                if(map[R][C] == K)
                {
                    flag = true;
                    break;
                }
            }
            ArrayList<ArrayList<Integer>> tmp_list = new ArrayList<>();
            if(r_size >= c_size) // r연산
            {
                for(int i = 0; i < r_size; ++i)
                {
                    tmp_list.add(new ArrayList<>());
                    Map<Integer,Integer> hm = new HashMap<>();
                    for(int n : map[i])
                    {
                        if(n > 0) hm.put(n,hm.getOrDefault(n,0)+1);
                    }
                    if(hm.size() * 2 > c_size)
                    {
                        c_size = hm.size() * 2;
                        if(c_size >= 100) c_size = 100;
                    }
                    PriorityQueue<Number> pq = new PriorityQueue<>(new Comparator<Number>() {
                        @Override
                        public int compare(Number o1, Number o2) {
                            if(o1.cnt == o2.cnt) return o1.n - o2.n;
                            return o1.cnt - o2.cnt;
                        }
                    });
                    for(int key : hm.keySet())
                    {
                        pq.add(new Number(key,hm.get(key)));
                    }
                    ArrayList<Integer> tmp = tmp_list.get(i);
                    while(!pq.isEmpty())
                    {
                        Number cur = pq.poll();
                        tmp.add(cur.n);
                        tmp.add(cur.cnt);
                    }
                }
                map = new int[r_size][c_size];
                for(int i = 0; i < tmp_list.size(); ++i)
                {
                    ArrayList<Integer> al = tmp_list.get(i);
                    for(int j = 0; j < al.size(); ++j)
                    {
                        if(j > 99) break;
                        map[i][j] = al.get(j);
                    }
                }
            }
            else // c연산
            {
                int tmp_r_size = r_size;
                for(int i = 0; i < c_size; ++i)
                {
                    tmp_list.add(new ArrayList<>());
                    Map<Integer,Integer> hm = new HashMap<>();
                    for(int j = 0 ; j < tmp_r_size; ++j)
                    {
                        if(map[j][i] > 0) hm.put(map[j][i],hm.getOrDefault(map[j][i],0)+1);
                    }
                    if(hm.size() * 2 > r_size)
                    {
                        r_size = hm.size() * 2;
                        if(r_size >= 100) r_size = 100;
                    }
                    PriorityQueue<Number> pq = new PriorityQueue<>(new Comparator<Number>() {
                        @Override
                        public int compare(Number o1, Number o2) {
                            if(o1.cnt == o2.cnt) return o1.n - o2.n;
                            return o1.cnt - o2.cnt;
                        }
                    });
                    for(int key : hm.keySet())
                    {
                        pq.add(new Number(key,hm.get(key)));
                    }
                    ArrayList<Integer> tmp = tmp_list.get(i);
                    while(!pq.isEmpty())
                    {
                        Number cur = pq.poll();
                        tmp.add(cur.n);
                        tmp.add(cur.cnt);
                    }
                }
                map = new int[r_size][c_size];
                for(int i = 0; i < tmp_list.size(); ++i)
                {
                    ArrayList<Integer> al = tmp_list.get(i);
                    for(int j = 0; j < al.size(); ++j)
                    {
                        if(j > 99) break;
                        map[j][i] = al.get(j);
                    }
                }
            }
        }
        if(flag) t--;
        else t = -1;
        System.out.print(t);
    }
}
