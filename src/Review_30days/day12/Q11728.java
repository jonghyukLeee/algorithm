package Review_30days.day12;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) pq.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; ++i) pq.add(Integer.parseInt(st.nextToken()));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(!pq.isEmpty()) bw.write(pq.poll()+" ");
        bw.flush();
        bw.close();
    }
}
