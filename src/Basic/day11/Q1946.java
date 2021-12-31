package Basic.day11;

import java.io.*;
import java.util.*;

class Score
{
    int doc,iv;

    public Score(int doc, int iv)
    {
        this.doc = doc;
        this.iv = iv;
    }
}
public class Q1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t-- > 0)
        {
            int n = Integer.parseInt(br.readLine());
            List<Score> list = new ArrayList<>();
            for(int i = 0; i < n; ++i)
            {
                st = new StringTokenizer(br.readLine());
                int fst = Integer.parseInt(st.nextToken());
                int sec = Integer.parseInt(st.nextToken());
                list.add(new Score(fst,sec));
            }
            Collections.sort(list, new Comparator<Score>() {
                @Override
                public int compare(Score o1, Score o2) {
                    return o1.doc - o2.doc;
                }
            });
            int cnt = 1;
            int tmp_rank = list.get(0).iv;
            int size = list.size();
            for(int i = 1; i < size; ++i)
            {
                int cur = list.get(i).iv;
                if(cur < tmp_rank)
                {
                    cnt++;
                    tmp_rank = cur;
                }
            }
            bw.write(cnt+"\n");
        }
        bw.flush();
        bw.close();
    }

}
