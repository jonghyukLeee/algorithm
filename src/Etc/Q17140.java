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
    static List<Integer> [] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken())-1;
        C = Integer.parseInt(st.nextToken())-1;
        K = Integer.parseInt(st.nextToken());

        map = new List[3];
        for(int i = 0; i < 3; ++i)
        {
            map[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; ++j)
            {
                map[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int r_size = 3;
        int c_size = 3;
        int t = 0;
        while(t++ < 100)
        {
            if((R < r_size) && (C < c_size))
            {
                if(map[R].get(C) == K) break;
            }
            if(r_size >= c_size) // r연산
            {
                for(int i = 0; i < r_size; ++i)
                {
                    Map<Integer,Integer> hm = new HashMap<>();
                    for(int n : map[i])
                    {
                        hm.put(n,hm.getOrDefault(n,0)+1);
                    }
                    if(hm.size() * 2 > c_size)
                    {
                        c_size = hm.size() * 2;
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
                    map[i].clear();
                    while(!pq.isEmpty())
                    {
                        Number cur = pq.poll();
                        map[i].add(cur.n);
                        map[i].add(cur.cnt);
                    }
                }
            }
            else // c연산
            {
                for(int i = 0; i < c_size; ++i)
                {

                }
            }
        }
        t = t == 100 ? -1 : t-1;
        System.out.print(t);
    }
    static void sortArr()
    {

    }
}
