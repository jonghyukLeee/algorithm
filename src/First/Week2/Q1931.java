package First.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Conf
{
    int start,end;
    boolean same;

    public Conf(int start, int end)
    {
        if(start == end) same = true;
        this.start = start;
        this.end = end;
    }
}
public class Q1931 {
    static List<Conf> al;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int res = Integer.MIN_VALUE;
        int tmp = 0;
        int cnt = 0;
        int n = Integer.parseInt(br.readLine());
        al = new ArrayList<>();
        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            al.add(new Conf(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(al, new Comparator<Conf>() {
            @Override
            public int compare(Conf o1, Conf o2) {
                if(o1.end == o2.end)
                {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });
        for(int i = 0; i < n; ++i)
        {
            tmp = i;
            cnt = 1;
            for(int j = i+1; j < n; ++j)
            {
                if(al.get(j).same)
                {
                    cnt++;
                    continue;
                }
                if(al.get(tmp).end <= al.get(j).start)
                {
                    cnt++;
                    tmp = j;
                }
            }
            res = Math.max(res,cnt);
        }
        System.out.print(res);
        br.close();
    }

}
