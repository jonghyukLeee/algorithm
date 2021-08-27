package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1766 {
    static PriorityQueue<Integer> pq;
    static ArrayList<ArrayList<Integer>> map;
    static int [] preCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        preCnt = new int[n+1];

        for(int i = 0; i <= n; ++i) map.add(new ArrayList<>());

        for(int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int fst = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            map.get(fst).add(sec);
            preCnt[sec]++;
        }

        pq = new PriorityQueue<>();
        for(int i = 1; i <= n; ++i) if(preCnt[i] == 0) pq.add(i);

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty())
        {
            int cur = pq.poll();
            sb.append(cur).append(" ");

            for(int i : map.get(cur))
            {
                preCnt[i]--;
                if(preCnt[i] == 0) pq.add(i);
            }
        }

        System.out.print(sb.toString());
    }
}
