import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K;
    static long [] map;
    static long [] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new long[N+1];
        for(int i = 1; i <= N; ++i) map[i] = Long.parseLong(br.readLine());

        // 세그먼트 트리 생성
        tree = new long[N*4];
        setTree(1,N,1);

        int t = M+K;
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while(t-- > 0)
        {
            st = new StringTokenizer(br.readLine());

            if(st.nextToken().equals("1")) // 변경
            {
                int idx = Integer.parseInt(st.nextToken());
                long val = Long.parseLong(st.nextToken());
                long diff = val-map[idx];
                update(1,N,1,idx,diff);
            }
            else // 합 찾기
            {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                //bw.write(findSum(1,N,start,end,1)+"\n");
                sb.append(findSum(1,N,start,end,1)).append("\n");
            }
        }
//        bw.flush();
//        bw.close();
        System.out.print(sb);
    }
    static long setTree(int start,int end,int nodeNum)
    {
        if(start == end)
        {
            return tree[nodeNum] = map[start];
        }

        int mid = (start + end) / 2;
        return tree[nodeNum] = setTree(start,mid,nodeNum * 2) + setTree(mid+1,end,(nodeNum*2) + 1);
    }

    static void update(int start, int end,int nodeNum, int idx, long diff)
    {
        if(idx < start || idx > end) return;
        tree[nodeNum] += diff;
        if(start == end) map[idx] = tree[nodeNum];
        if(start != end)
        {
            int mid = (start + end) / 2;
            update(start,mid,nodeNum * 2,idx,diff);
            update(mid + 1,end,(nodeNum * 2) + 1,idx,diff);
        }
    }

    static long findSum(int start, int end, int left, int right, int nodeNum)
    {
        if((left > end) || (right < start)) return 0;
        else if((left <= start) && (right >= end)) return tree[nodeNum];
        else
        {
            int mid = (start + end) / 2;
            return findSum(start,mid,left,right,nodeNum * 2) + findSum(mid+1,end,left,right,(nodeNum * 2) + 1);
        }
    }
}
